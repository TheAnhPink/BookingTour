import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

// Import CSS theo đúng thứ tự: global → layout → home
import './styles/global.css';
import './styles/layout.css';
import './styles/home.css';

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);