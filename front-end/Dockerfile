FROM node:7.10 as build-deps
ENV NPM_CONFIG_LOGLEVEL=warn
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY . ./
CMD ["npm", "start"]