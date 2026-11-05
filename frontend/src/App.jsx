import { BrowserRouter } from 'react-router-dom';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import Home from './pages/Home';

export default function App() {
    return (
        <BrowserRouter>
            <Header />
            <main>
                <Home />
            </main>
            <Footer />
        </BrowserRouter>
    );
}