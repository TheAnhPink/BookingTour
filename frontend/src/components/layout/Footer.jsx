import './../../styles/layout.css';

export default function Footer() {
    return (
        <footer className="footer">
            <div className="container footer-grid">
                <div className="footer-col brand">
                    <div className="logo">
                        <span className="logo-icon">🌍</span>
                        <span className="logo-text">Collette</span>
                    </div>
                    <p>By Travelers. For Travelers.®</p>
                    <p className="footer-copy">© 2026 Collette. All rights reserved.</p>
                </div>

                <div className="footer-col">
                    <h4>Explore</h4>
                    <ul>
                        <li><a href="#">Destinations</a></li>
                        <li><a href="#">Ways to Travel</a></li>
                        <li><a href="#">Deals</a></li>
                        <li><a href="#">Featured Tours</a></li>
                    </ul>
                </div>

                <div className="footer-col">
                    <h4>About</h4>
                    <ul>
                        <li><a href="#">Our Story</a></li>
                        <li><a href="#">Tour Guides</a></li>
                        <li><a href="#">Reviews</a></li>
                        <li><a href="#">Careers</a></li>
                    </ul>
                </div>

                <div className="footer-col">
                    <h4>Support</h4>
                    <ul>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Travel Protection</a></li>
                        <li><a href="#">Terms & Privacy</a></li>
                    </ul>
                </div>
            </div>
        </footer>
    );
}