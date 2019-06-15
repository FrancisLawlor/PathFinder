export default class HTTPClient {
  static postRequest(url, body) {
    return fetch(url, {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body)
    })
      .then(response => response.json())
      .then(data => {
        return new Promise(resolve => {
          resolve(data);
        });
      });
  }

  static getRequest(url) {
    return fetch(url, {
      method: "get",
      headers: { "Content-Type": "application/json" }
    })
      .then(response => response.json())
      .then(data => {
        return new Promise(resolve => {
          resolve(data);
        });
      });
  }
}
