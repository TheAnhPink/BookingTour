import { Link } from 'react-router-dom';
import './../../styles/layout.css';

export default function Header() {
    return (
        <header className="header">
            <div className="container header-inner">
                {/* Logo */}
                <Link to="/" className="logo">
                    <span className="logo-icon">🌍</span>
                    <span className="logo-text">Collette</span>
                </Link>

                {/* Navigation */}
                <nav className="nav">
                    <a href="#" className="nav-link">Our Tours</a>
                    <a href="#" className="nav-link">Destinations</a>
                    <a href="#" className="nav-link">Ways to Travel</a>
                    <a href="#" className="nav-link">Deals</a>
                    <a href="#" className="nav-link">About Us</a>
                </nav>

                {/* Actions */}
                <div className="header-actions">
                    <a href="#" className="header-phone">📞 1-800-123-4567</a>
                    <a href="#" className="btn btn-outline btn-sm">Sign In</a>
                </div>
            </div>
        </header>
    );
}