

import psycopg2
import telebot
import csv
import pymorphy2
from telebot import types
import requests
import json
import re
# import sklearn
# import numpy as np





# conn = psycopg2.connect(dbname='TgBot', user='postgres', password='1234', host='localhost', port="5432")
# cursor = conn.cursor()

morph = pymorphy2.MorphAnalyzer(lang='ru')

bot = telebot.TeleBot('5808071065:AAF_Cyc3bQrgKIdhnVDDjwC-CyiNLwS_ICU')




login_data = {}
login =""
passwword= ""
jwt_token=''

@bot.message_handler(commands=[ 'help'])
def send_welcome(message):
	bot.reply_to(message, "Howdy, how are you doing?")

@bot.message_handler(commands=['start'])
def start(message):
    markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
    item1 = types.KeyboardButton("Войти ")
    item2 = types.KeyboardButton("Зарегистрироваться")

    markup.add(item1, item2)
    bot.send_message(message.chat.id, "Выберите опцию:", reply_markup=markup)



@bot.message_handler(func=lambda message: message.text == "Войти")
def registration(message):
    bot.send_message(message.chat.id, "Вы выбрали авторизацию. Пожалуйста, введите свои данные.")
    bot.send_message(message.chat.id," введите логин:")
    bot.register_next_step_handler(message, save_login)

@bot.message_handler(func=lambda message: message.text == "Зарегистрироваться")
def authorization(message):
    bot.send_message(message.chat.id, "Вы выбрали регистрацию. Пожалуйста, введите свои учетные данные.")
    bot.register_next_step_handler(message, reg_login)

def save_login(message):
    login = message.text
    chat_id = message.chat.id
    login_data[chat_id] = {"name": login}
    bot.send_message(chat_id, "Логин успешно сохранен. Теперь введите пароль:")
    bot.register_next_step_handler(message, lambda message: save_password(message, login))

def save_password(message, login):
    global jwt_token
    password = message.text
    chat_id = message.chat.id
    login_data[chat_id]["password"] = password
    bot.send_message(chat_id, "Пароль успешно сохранен.")
    url = "http://localhost:3333/auth/signin"
    data = {
        "name": login,
        "password": password
    }
    headers = {
        "Content-Type": "application/json"
    }
    print(data)
    response = requests.post(url, data=json.dumps(data), headers=headers )
    if response.status_code == 200:
        data = response
        bot.send_message(chat_id,data)
        jwt_token=response.text

        markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
        item1 = types.KeyboardButton("Тренеровки ")
        markup.add(item1)
        bot.send_message(message.chat.id, "Выберите опцию:", reply_markup=markup)
    else:
        bot.send_message(chat_id,"Ошибка при выполнении запроса")




def reg_login(message):
    login = message.text
    chat_id = message.chat.id
    login_data[chat_id] = {"name": login}
    bot.send_message(chat_id, "Логин успешно сохранен. Теперь введите почту:")
    bot.register_next_step_handler(message, lambda message: reg_email(message, login))

def reg_email(message, login):
    email = message.text

    chat_id = message.chat.id
    login_data[chat_id] = {"email": email}
    bot.send_message(chat_id, "email успешно сохранен. Теперь введите пароль:")
    bot.register_next_step_handler(message, lambda message: reg_password(message, login ,email))




def reg_password(message, login,email):
    password = message.text
    chat_id = message.chat.id
    login_data[chat_id]["password"] = password
    bot.send_message(chat_id, "Пароль успешно сохранен.")
    url = "http://localhost:3333/auth/signup"
    data = {
        "name": login,
        "email": email,
        "password": password
    }
    headers = {
        "Content-Type": "application/json"
    }
    print(data)
    response = requests.post(url, data=json.dumps(data), headers=headers )
    if response.status_code == 200:
        data = response
        bot.send_message(chat_id,data)
    else:
        bot.send_message(chat_id,"Ошибка при выполнении запроса")





@bot.message_handler(func=lambda message: message.text == "Тренеровки")
def get_worcouts(message):


    chat_id = message.chat.id
    global jwt_token
    bot.send_message(chat_id,"Все доступные тренеровки")
    url = "http://localhost:3333/authorized/get/workouts/"

    headers= {
        "Authorization": "Bearer " + jwt_token
    }

    response = requests.get(url, headers=headers)
    if response.status_code == 200:

        workouts = response.json()

        formatted_workouts = "\n".join([f" название: {workout['name']} \n описание:{workout['description']} \n начало тренеровки:{workout['start_date']} \n конец тренеровки:{workout['end_date']} \n \n " for workout in workouts])

        bot.send_message(chat_id,formatted_workouts)
    else:
        bot.send_message(chat_id,"Ошибка при выполнении запроса")



# @bot.message_handler(func=lambda m: True)
def echo_all(message):
	bot.reply_to(message, message.text)














bot.infinity_polling()