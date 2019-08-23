FROM node:latest as build-deps
ENV NPM_CONFIG_LOGLEVEL=warn
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
RUN npm install -g serve
COPY . ./
CMD ["serve", "-s", "build"]