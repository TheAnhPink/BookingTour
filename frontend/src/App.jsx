import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import Home from './pages/Home';
import TourList from './pages/TourList'; 
import Deals from './pages/Deals';
import TourDetail from './pages/TourDetail';
import BookingPage from './pages/BookingPage';

// SỬA LẠI ĐƯỜNG DẪN IMPORT Ở ĐÂY (Thêm travelStyle/)
import ClassicTours from './pages/travelStyle/ClassicTours';
import SmallGroupTours from './pages/travelStyle/SmallGroupTours';
import SpotlightTours from './pages/travelStyle/SpotlightTours';
import CruiseTours from './pages/travelStyle/CruiseTours';
import FaithBasedTours from './pages/travelStyle/FaithBasedTours';
import PrivateGroupTours from './pages/travelStyle/PrivateGroupTours';
import SoloTravelTours from './pages/travelStyle/SoloTravelTours';
import MultigenerationalTours from './pages/travelStyle/MultigenerationalTours';
import WhyColletteOverview from './pages/whyCollette/WhyColletteOverview';
import OurValues from './pages/whyCollette/OurValues';
import SustainableTravel from './pages/whyCollette/SustainableTravel';
import TravelCompanyHistory from './pages/whyCollette/TravelCompanyHistory';

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
                    
                    {/* Đường dẫn URL (Route path) thì GIỮ NGUYÊN, không đổi */}
                    <Route path="/travel-styles/classic-tours" element={<ClassicTours />} />
                    <Route path="/travel-styles/small-group-tours" element={<SmallGroupTours />} />
                    <Route path="/travel-styles/spotlight-tours" element={<SpotlightTours />} />
                    <Route path="/travel-styles/cruise-tours" element={<CruiseTours />} />
                    <Route path="/travel-styles/faith-based-travel" element={<FaithBasedTours />} />
                    <Route path="/travel-styles/private-group-tours" element={<PrivateGroupTours />} />
                    <Route path="/travel-styles/solo-travel-tours" element={<SoloTravelTours />} />
                    <Route path="/travel-styles/multigenerational-travel" element={<MultigenerationalTours />} />
                    
                    <Route path="/why-collette" element={<WhyColletteOverview />} />
                    <Route path="/why-collette/our-values" element={<OurValues />} />
                    <Route path="/why-collette/sustainable-travel" element={<SustainableTravel />} />
                    <Route path="/why-collette/travel-company-history" element={<TravelCompanyHistory />} />
                </Routes>
            </main>
            <Footer />
        </BrowserRouter>
    );
}