import './../../styles/home.css';

export default function HeroSection() {
    return (
        <section className="hero">
            <div className="hero-overlay" />
            <div className="hero-content container">
                <p className="hero-tagline">By Travelers. For Travelers.®</p>
                <h1>Expertly crafted guided tours for the modern traveler</h1>
                <p className="hero-desc">
                    Discover the world with confidence. Over 32,000+ five-star reviews.
                </p>
                <div className="hero-actions">
                    <button className="btn btn-primary">Explore Tours</button>
                    <button className="btn btn-white">Find Your Trip</button>
                </div>
            </div>
        </section>
    );
}