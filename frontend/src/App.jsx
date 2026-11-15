import { BrowserRouter, Routes, Route, Outlet } from 'react-router-dom';

// Layouts
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import AdminLayout from './components/layout/adminLayout/AdminLayout'; 

// Pages (Khách)
import Home from './pages/Home';
import TourList from './pages/TourList'; 
import Deals from './pages/Deals';
import TourDetail from './pages/TourDetail';
import BookingPage from './pages/BookingPage';

// Pages (Travel Styles)
import ClassicTours from './pages/travelStyle/ClassicTours';
import SmallGroupTours from './pages/travelStyle/SmallGroupTours';
import SpotlightTours from './pages/travelStyle/SpotlightTours';
import CruiseTours from './pages/travelStyle/CruiseTours';
import FaithBasedTours from './pages/travelStyle/FaithBasedTours';
import PrivateGroupTours from './pages/travelStyle/PrivateGroupTours';
import SoloTravelTours from './pages/travelStyle/SoloTravelTours';
import MultigenerationalTours from './pages/travelStyle/MultigenerationalTours';

// Pages (Why Collette)
import WhyColletteOverview from './pages/whyCollette/WhyColletteOverview';
import OurValues from './pages/whyCollette/OurValues';
import SustainableTravel from './pages/whyCollette/SustainableTravel';
import TravelCompanyHistory from './pages/whyCollette/TravelCompanyHistory';

// Pages (Admin - Bạn cần tạo các file này trong thư mục src/pages/admin/)
import AdminDashboard from './pages/admin/Dashboard';
import AdminTourManage from './pages/admin/TourManage';
import AdminOrderManage from './pages/admin/OrderManage';

// Component Layout cho Khách (Gộp Header + Footer)
function PublicLayout() {
    return (
        <>
            <Header />
            <main>
                <Outlet /> {/* Các trang con của khách sẽ hiển thị ở đây */}
            </main>
            <Footer />
        </>
    );
}

export default function App() {
    return (
        <BrowserRouter>
            <Routes>
                {/* ==========================================
                    KHU VỰC KHÁCH HÀNG (Có Header & Footer)
                ========================================== */}
                <Route element={<PublicLayout />}>
                    <Route path="/" element={<Home />} />
                    <Route path="/find-your-tour" element={<TourList />} />
                    <Route path="/deals" element={<Deals />} />
                    <Route path="/tour/:id" element={<TourDetail />} />
                    <Route path="/booking/:id" element={<BookingPage />} />
                    
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
                </Route>

                {/* ==========================================
                    KHU VỰC ADMIN (Chỉ có Sidebar & Topbar riêng)
                    Cach test: http://localhost:5173/admin
                ========================================== */}
                <Route path="/admin" element={<AdminLayout />}>
                    <Route index element={<AdminDashboard />} />
                    <Route path="tours" element={<AdminTourManage />} />
                    <Route path="orders" element={<AdminOrderManage />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}