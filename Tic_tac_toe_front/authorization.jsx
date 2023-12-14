import React, { useState } from 'react';

const GothicAuthPage = () => {
  const [isLogin, setIsLogin] = useState(true);

  const toggleAuthType = () => {
    setIsLogin(!isLogin);
  };

  return (
    <div
      style={{
        backgroundColor: 'black',
        color: 'white',
        height: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        fontFamily: 'Gothic, sans-serif',
      }}
    >
      <div
        style={{
          width: '400px',
          padding: '20px',
          border: '2px solid white',
          borderRadius: '10px',
          textAlign: 'center',
          background: 'linear-gradient(to right, #1c1c1c, #262626)',
        }}
      >
        <h1 style={{ marginBottom: '20px', color: 'white' }}>
          {isLogin ? 'Авторизация' : 'Регистрация'}
        </h1>
        <form style={{ display: 'flex', flexDirection: 'column' }}>
          <label style={{ marginBottom: '10px' }} htmlFor="username">
            Имя пользователя:
          </label>
          <input
            style={{
              padding: '8px',
              marginBottom: '15px',
              borderRadius: '5px',
              border: '1px solid white',
              backgroundColor: '#333',
              color: 'white',
            }}
            type="text"
            id="username"
          />

          <label style={{ marginBottom: '10px' }} htmlFor="password">
            Пароль:
          </label>
          <input
            style={{
              padding: '8px',
              marginBottom: '15px',
              borderRadius: '5px',
              border: '1px solid white',
              backgroundColor: '#333',
              color: 'white',
            }}
            type="password"
            id="password"
          />

            {!isLogin && (
            <React.Fragment>
                <label style={{ marginBottom: '10px' }} htmlFor="email">
                Email:
                </label>
                <input
                style={{
                    padding: '8px',
                    marginBottom: '15px',
                    borderRadius: '5px',
                    border: '1px solid white',
                    backgroundColor: '#333',
                    color: 'white',
                }}
                type="email"
                id="email"
                />
            </React.Fragment>
            )}


          <button
            style={{
              padding: '10px',
              backgroundColor: 'white',
              color: 'black',
              borderRadius: '5px',
              cursor: 'pointer',
            }}
            type="submit"
          >
            {isLogin ? 'Войти' : 'Зарегистрироваться'}
          </button>
        </form>

        <p
          onClick={toggleAuthType}
          style={{
            cursor: 'pointer',
            marginTop: '20px',
            color: 'white',
            textDecoration: 'underline',
          }}
        >
          {isLogin ? 'Нет аккаунта? Зарегистрируйтесь.' : 'Уже есть аккаунт? Войдите.'}
        </p>
      </div>
    </div>
  );
};

export default GothicAuthPage;
