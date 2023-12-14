
import { startNewGame } from './api';
import {login} from './api';

// В вашем коде, где вы хотите начать новую игру
async function handleNewGame() {
  try {
    const gameData = await startNewGame();
    // Обработайте данные о новой игре, если это необходимо
  } catch (error) {
    // Обработайте ошибку, если не удалось начать новую игру
  }
}

async function handlePlay(nextSquares) {
    const winner = calculateWinner(nextSquares);
    if (winner) {
      try {
        const token = await login/* Получите токен, например, с помощью функции authenticate */;
        await sendGameResult(winner, token);
      } catch (error) {
        console.error('Failed to send game result', error);
      }
    }
  
    const nextHistory = [...history.slice(0, currentMove + 1), nextSquares];
    setHistory(nextHistory);
    setCurrentMove(nextHistory.length - 1);
  }
