# Используем официальный образ Ubuntu в качестве основы
FROM ubuntu:20.04

# Устанавливаем необходимые зависимости и утилиты
RUN apt-get update && \
    apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa && \
    apt-get update && \
    apt-get install -y openjdk-21-jdk \
                       python3.8 \
                       python3-pip \
                       nodejs \
                       npm \
                       curl \
                       wget \
                       supervisor && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
# Создаем рабочие директории
WORKDIR /app

# Устанавливаем Java проект
COPY Fitnes_Club/build/libs/Fitnes_Club-0.0.1-SNAPSHOT-plain.jar /app/java/app.jar
ENV JAVA_OPTS="-Dspring.profiles.active=production"

# Устанавливаем Python проект
COPY TgBot/requirements.txt /app/python/requirements.txt
RUN pip3 install --no-cache-dir -r /app/python/requirements.txt
COPY TgBot /app/python

# Устанавливаем Node.js проект
COPY vue-project/package*.json /app/node/
RUN cd /app/node && npm install
COPY vue-project /app/node
RUN cd /app/node && npm run build

# Настраиваем supervisord
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

# Открываем порты
EXPOSE 8080 5000 80

# Запускаем supervisord для управления процессами
CMD ["/usr/bin/supervisord"]
