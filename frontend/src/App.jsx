import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import Home from './pages/Home';
import TourList from './pages/TourList'; 
import Deals from './pages/Deals';
import TourDetail from './pages/TourDetail';
import BookingPage from './pages/BookingPage';

export default function App() {
    return (
        <BrowserRouter>
            <Header />
            <main>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/find-your-tour" element={<TourList />} />
                    <Route path="/deals" element={<Deals />} />
                    <Route path="/tour/:id" element={<TourDetail />} />
                    <Route path="/booking/:id" element={<BookingPage />} />
                </Routes>
            </main>
            <Footer />
        </BrowserRouter>
    );
}