// api.js

const API_URL = 'http://localhost:8080';

async function register(username, password) {
  const response = await fetch(`${API_URL}/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ username, password }),
  });

  if (!response.ok) {
    throw new Error('Registration failed');
  }

  const data = await response.json();
  return data.token;//втсавлять в куки
}

async function login(username, password) {
  const response = await fetch(`${API_URL}/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ username, password }),
  });

  if (!response.ok) {
    throw new Error('Login failed');
  }

  const data = await response.json();
  return data.token;
}


async function fetchGameData(token) {
  const response = await fetch(`${API_URL}/game-data`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
  });

  if (!response.ok) {
    throw new Error('Failed to fetch game data');
  }

  const data = await response.json();
  return data;
}

async function sendMove(token, move) {
  const response = await fetch(`${API_URL}/make-move`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
    body: JSON.stringify({ move }),
  });

  if (!response.ok) {
    throw new Error('Failed to send move');
  }

  const data = await response.json();
  return data;
}


export { authenticate, fetchGameData, sendMove };

async function sendGameResult(winner, token) {
    const response = await fetch(`${API_URL}/game-result`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
      body: JSON.stringify({ winner }),
    });
  
    if (!response.ok) {
      throw new Error('Failed to send game result');
    }
  
    // Обработайте ответ, если это необходимо
}

async function getPlayerStatistics(token) {
    const response = await fetch(`${API_URL}/player-statistics`, {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${token}`,
      },
    });
  
    if (!response.ok) {
      throw new Error('Failed to get player statistics');
    }
  
    const data = await response.json();
    return data;
  }

  async function sendGameResult(winner, token) {
    const response = await fetch(`${API_URL}/game-result`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
      body: JSON.stringify({ winner }),
    });
  
    if (!response.ok) {
      throw new Error('Failed to send game result');
    }
  
    // Обработайте ответ, если это необходимо
  }

