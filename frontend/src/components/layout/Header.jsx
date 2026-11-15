import { Link } from 'react-router-dom';
import '../../styles/layout.css'; 

export default function Header() {
    return (
        <header className="header">
            <div className="container header-inner">
                {/* Logo */}
                <Link to="/" className="logo">
                    <span>🌍</span> Collette
                </Link>

                {/* Menu */}
                <nav className="nav">
                    
                    {/* 1. OUR TOURS DROPDOWN */}
                    <div className="nav-dropdown">
                        <a href="#" className="nav-link">
                            Our Tours ▾
                        </a>
                        
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

                    {/* Link bình thường */}
                    <a href="#" className="nav-link">Destinations</a>

                    {/* 2. WAYS TO TRAVEL DROPDOWN (Đã sửa thành Link) */}
                    <div className="nav-dropdown">
                        <a href="#" className="nav-link">
                            Ways to Travel ▾
                        </a>
                        
                        <div className="mega-menu">
                            <div className="mega-sidebar">
                                <a href="#" className="mega-sidebar-item active">
                                    Ways to Travel <span>›</span>
                                </a>
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
                        <a href="#" className="nav-link">
                            Why Collette ▾
                        </a>
                        
                        <div className="mega-menu">
                            <div className="mega-sidebar">
                                <Link to="/why-collette" className="mega-sidebar-item active">
                                    Why Collette <span>›</span>
                                </Link>
                                <Link to="/why-collette/our-values" className="mega-sidebar-item">
                                    Our Values <span>›</span>
                                </Link>
                                <Link to="/why-collette/sustainable-travel" className="mega-sidebar-item">
                                    Sustainable Travel <span>›</span>
                                </Link>
                                <Link to="/why-collette/travel-company-history" className="mega-sidebar-item">
                                    Travel Company History <span>›</span>
                                </Link>
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
                        <a href="#" className="nav-link">
                            Travel Planning ▾
                        </a>
                        
                        <div className="mega-menu">
                            <div className="mega-sidebar">
                                <a href="#" className="mega-sidebar-item active">
                                    Travel Planning <span>›</span>
                                </a>
                                <a href="#" className="mega-sidebar-item">
                                    Destination Inspiration <span>›</span>
                                </a>
                                <a href="#" className="mega-sidebar-item">
                                    Eat Drink Travel <span>›</span>
                                </a>
                                <a href="#" className="mega-sidebar-item">
                                    Helpful Links <span>›</span>
                                </a>
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

                    {/* Link bình thường */}
                    <Link className="nav-link" to="/deals">Deals</Link>
                </nav>

                {/* Bên phải */}
                <div className="header-actions">
                    <span style={{ marginRight: '15px', fontWeight: 'bold' }}>📞 0816969671</span>
                    <a href="#" className="btn btn-outline btn-sm">Sign In</a>
                </div>
            </div>
        </header>
    );
}