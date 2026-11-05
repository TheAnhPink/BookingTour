import { Link } from 'react-router-dom';
// Nhớ import file css
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
                    {/* Phần dropdown Our Tours */}
                    <div className="nav-dropdown">
                        <a href="#" className="nav-link">
                            Our Tours ▾
                        </a>
                        
                        <div className="mega-menu">
                            {/* Nội dung menu con (Sidebar và Content) */}
                            <div className="mega-sidebar">
                                <a href="#" className="mega-sidebar-item active">⭐ New Tours ›</a>
                                <a href="#" className="mega-sidebar-item">🌎 North America ›</a>
                                <a href="#" className="mega-sidebar-item">🌍 Europe ›</a>
                                <a href="#" className="mega-sidebar-item">🌏 Asia ›</a>
                            </div>
                            <div className="mega-content">
                                <h3>New Tours</h3>
                                <ul>
                                    <li><a href="#">Africa</a></li>
                                    <li><a href="#">Antarctica</a></li>
                                    <li><a href="#">Asia</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    {/* Các link bình thường */}
                    <a href="#" className="nav-link">Destinations</a>
                    <a href="#" className="nav-link">Ways to Travel</a>
                    <a href="#" className="nav-link">Deals</a>
                </nav>

                {/* Bên phải */}
                <div className="header-actions">
                    <span style={{ marginRight: '15px', fontWeight: 'bold' }}>📞 1-800-123-4567</span>
                    <a href="#" className="btn btn-outline btn-sm">Sign In</a>
                </div>
            </div>
        </header>
    );
}