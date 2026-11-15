import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import '../../styles/layout.css'; 

export default function Header() {
    // State để kiểm soát việc hiển thị thanh Top Bar
    const [showTopBar, setShowTopBar] = useState(true);

    useEffect(() => {
        let lastScrollY = window.scrollY;

        const handleScroll = () => {
            const currentScrollY = window.scrollY;

            // Nếu cuộn LÊN và vị trí chuột còn gần đầu trang (dưới 150px)
            if (currentScrollY < lastScrollY && currentScrollY < 150) {
                setShowTopBar(true);
            } 
            // Nếu cuộn XUỐNG
            else if (currentScrollY > lastScrollY) {
                setShowTopBar(false);
            }

            lastScrollY = currentScrollY;
        };

        window.addEventListener('scroll', handleScroll);
        return () => window.removeEventListener('scroll', handleScroll);
    }, []);

    return (
        <header className="header">
            {/* ==========================================
                THANH TOP BAR (LOG IN / SIGN UP) - ẨN/HIỆN KHI SCROLL
            ========================================== */}
            <div className={`top-bar ${showTopBar ? 'show' : 'hide'}`}>
                <div className="container top-bar-inner">
                    <div className="top-bar-right">
                        <a href="#" className="login-link">Log In / Sign Up</a>
                        <div className="language-selector">
                            <span>🇺🇸</span> US <span>›</span>
                        </div>
                    </div>
                </div>
            </div>

            {/* ==========================================
                THANH HEADER CHÍNH (MENU, LOGO)
            ========================================== */}
            <div className="container header-inner">
                {/* Logo */}
                <Link to="/" className="logo">
                    Collette
                </Link>

                {/* Menu */}
                <nav className="nav">
                    {/* 1. OUR TOURS DROPDOWN */}
                    <div className="nav-dropdown">
                        <a href="#" className="nav-link">Our Tours ▾</a>
                        <div className="mega-menu">
                            <div className="mega-sidebar">
                                <a href="#" className="mega-sidebar-item active">⭐ New Tours ›</a>
                                <a href="#" className="mega-sidebar-item">🌎 North America ›</a>
                                <a href="#" className="mega-sidebar-item">🌍 Europe ›</a>
                                <a href="#" className="mega-sidebar-item">🌏 Asia ›</a>
                                <a href="#" className="mega-sidebar-item">⋯ View All Destinations ›</a>
                            </div>
                            <div className="mega-content">
                                <div className="mega-content-header">
                                    <h3>New Tours</h3>
                                    <div className="mega-actions">
                                        <button className="btn-learn-more">Learn More</button>
                                        <Link to="/find-your-tour" className="btn-view-all" style={{ textDecoration: 'none', display: 'inline-block' }}>
                                            View All Tours
                                        </Link>
                                    </div>
                                </div>
                                <ul className="mega-list">
                                    <li><a href="#">Africa</a></li>
                                    <li><a href="#">Antarctica</a></li>
                                    <li><a href="#">Asia</a></li>
                                    <li><a href="#">Europe</a></li>
                                    <li><a href="#">North America</a></li>
                                    <li><a href="#">South America</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <a href="#" className="nav-link">Destinations</a>

                    {/* 2. WAYS TO TRAVEL DROPDOWN */}
                    <div className="nav-dropdown">
                        <a href="#" className="nav-link">Ways to Travel ▾</a>
                        <div className="mega-menu">
                            <div className="mega-sidebar">
                                <a href="#" className="mega-sidebar-item active">Ways to Travel <span>›</span></a>
                            </div>
                            <div className="mega-content">
                                <div className="mega-content-header">
                                    <h3>Ways to Travel</h3>
                                </div>
                                <ul className="mega-list mega-list-two-cols">
                                    <li><Link to="/travel-styles/classic-tours">Classic</Link></li>
                                    <li><Link to="/travel-styles/small-group-tours">Small Group Explorations</Link></li>
                                    <li><Link to="/travel-styles/spotlight-tours">Spotlights</Link></li>
                                    <li><Link to="/travel-styles/cruise-tours">Cruising</Link></li>
                                    <li><Link to="/travel-styles/faith-based-travel">Faith</Link></li>
                                    <li><Link to="/travel-styles/private-group-tours">Private</Link></li>
                                    <li><Link to="/travel-styles/solo-travel-tours">Solo Traveler</Link></li>
                                    <li><Link to="/travel-styles/multigenerational-travel">Multigenerational Travel</Link></li>
                                    <li><a href="#">Back to Back Tours</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>  

                    {/* 3. WHY COLLETTE DROPDOWN */}
                    <div className="nav-dropdown">
                        <a href="#" className="nav-link">Why Collette ▾</a>
                        <div className="mega-menu">
                            <div className="mega-sidebar">
                                <Link to="/why-collette" className="mega-sidebar-item active">Why Collette <span>›</span></Link>
                                <Link to="/why-collette/our-values" className="mega-sidebar-item">Our Values <span>›</span></Link>
                                <Link to="/why-collette/sustainable-travel" className="mega-sidebar-item">Sustainable Travel <span>›</span></Link>
                                <Link to="/why-collette/travel-company-history" className="mega-sidebar-item">Travel Company History <span>›</span></Link>
                            </div>
                            <div className="mega-content">
                                <div className="mega-content-header">
                                    <h3>Why Collette</h3>
                                    <div className="mega-actions">
                                        <Link to="/why-collette" className="btn-learn-more" style={{ textDecoration: 'none', display: 'inline-block' }}>
                                            Learn More
                                        </Link>
                                    </div>
                                </div>
                                <ul className="mega-list single-col">
                                    <li><Link to="/why-collette">The Collette Difference</Link></li>
                                    <li><Link to="/why-collette/our-values">Our Values</Link></li>
                                    <li><Link to="/why-collette/sustainable-travel">Sustainable Travel</Link></li>
                                    <li><Link to="/why-collette/travel-company-history">Travel Company History</Link></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                    {/* 4. TRAVEL PLANNING DROPDOWN */}
                    <div className="nav-dropdown">
                        <a href="#" className="nav-link">Travel Planning ▾</a>
                        <div className="mega-menu">
                            <div className="mega-sidebar">
                                <a href="#" className="mega-sidebar-item active">Travel Planning <span>›</span></a>
                                <a href="#" className="mega-sidebar-item">Destination Inspiration <span>›</span></a>
                                <a href="#" className="mega-sidebar-item">Eat Drink Travel <span>›</span></a>
                                <a href="#" className="mega-sidebar-item">Helpful Links <span>›</span></a>
                            </div>
                            <div className="mega-content">
                                <div className="mega-content-header">
                                    <h3>Travel Planning</h3>
                                </div>
                                <ul className="mega-list single-col">
                                    <li><a href="#">Benefits of Low Season</a></li>
                                    <li><a href="#">Collette Passport Club</a></li>
                                    <li><a href="#">Sedan Service</a></li>
                                    <li><a href="#">Travel Blog</a></li>
                                    <li><a href="#">Travel Protection</a></li>
                                    <li><a href="#">Virtual Events</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <Link className="nav-link" to="/deals">Deals</Link>
                </nav>

                {/* Khu vực bên phải (Điện thoại & Tìm kiếm) */}
                <div className="header-actions">
                    <div className="header-phone">
                        <span>📞 0816969671</span>
                        <small>or call your travel advisor</small>
                    </div>
                    <a href="#" className="btn-search">
                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="#0b1b2a" strokeWidth="2.5" strokeLinecap="round" strokeLinejoin="round">
                            <circle cx="11" cy="11" r="8"></circle>
                            <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                        </svg>
                    </a>
                </div>
            </div>
        </header>
    );
}