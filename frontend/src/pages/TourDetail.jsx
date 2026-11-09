import { useParams, Link ,useNavigate} from 'react-router-dom';
import { mockTourDetail } from '../data/mockTourDetail';
import '../styles/tourDetail.css';

export default function TourDetail() {
    const { id } = useParams();
    const tour = mockTourDetail; 
    const navigate = useNavigate();

    return (
        <div className="tour-detail-page">
            {/* Hero Section */}
            <section className="tour-hero" style={{ backgroundImage: `url(${tour.image})` }}>
                <div className="hero-overlay">
                    <div className="container">
                        <div className="hero-badges">
                            <span className="badge-new">New Tour</span>
                            <span className="badge-style">Classic</span>
                            <span className="badge-style">Holiday</span>
                        </div>
                        <h1>{tour.title}</h1>
                        <p className="hero-location">📍 {tour.location}</p>
                    </div>
                </div>
            </section>

            {/* Quick Info Bar */}
            <div className="quick-info-bar">
                <div className="container quick-info-grid">
                    <div className="info-item">
                        <span className="info-label">DAYS</span>
                        <span className="info-value">{tour.duration}</span>
                    </div>
                    <div className="info-item">
                        <span className="info-label">GROUP SIZE</span>
                        <span className="info-value">{tour.groupSize}</span>
                    </div>
                    <div className="info-item">
                        <span className="info-label">FROM (PER PERSON*)</span>
                        <span className="info-value price">${tour.price} <span className="old-price">${tour.originalPrice}</span></span>
                    </div>
                    <div className="info-item">
                        <span className="info-label">REVIEWS</span>
                        <span className="info-value">⭐ {tour.rating} ({tour.reviews})</span>
                    </div>
                    <div className="info-item">
                        <span className="info-label">ACTIVITY LEVEL</span>
                        <span className="info-value">{tour.activityLevel}</span>
                    </div>
                    <div className="info-item">
                        <span className="info-label">MEALS</span>
                        <span className="info-value">{tour.meals}</span>
                    </div>
                    <div className="info-item">
                        <span className="info-label">TRAVEL STYLE</span>
                        <span className="info-value">{tour.travelStyle}</span>
                    </div>
                </div>
            </div>

            <div className="container tour-detail-content">
                {/* Tour Overview */}
                <section className="detail-section">
                    <h2>Tour Overview</h2>
                    <p>{tour.overview}</p>
                </section>

                {/* Highlights */}
                <section className="detail-section">
                    <h2>Highlights</h2>
                    <div className="highlights-grid">
                        {tour.highlights.map((item, index) => (
                            <div key={index} className="highlight-item">
                                <span className="highlight-icon">✓</span>
                                <span>{item}</span>
                            </div>
                        ))}
                    </div>
                </section>

                {/* Inclusions & Featured Experiences */}
                <section className="detail-section">
                    <h2>Inclusions & Featured Experiences</h2>
                    <div className="inclusions-grid">
                        <div className="inclusion-card">
                            <h3>🍽️ Meals</h3>
                            <p>{tour.inclusions.meals}</p>
                        </div>
                        <div className="inclusion-card">
                            <h3>🏨 Accommodations</h3>
                            <p>{tour.inclusions.accommodations}</p>
                        </div>
                        <div className="inclusion-card">
                            <h3>🎭 Cultural Experiences</h3>
                            <ul>
                                {tour.inclusions.culturalExperiences.map((exp, i) => (
                                    <li key={i}>{exp}</li>
                                ))}
                            </ul>
                        </div>
                        <div className="inclusion-card">
                            <h3>🍷 Culinary Inclusions</h3>
                            <ul>
                                {tour.inclusions.culinaryInclusions.map((exp, i) => (
                                    <li key={i}>{exp}</li>
                                ))}
                            </ul>
                        </div>
                    </div>
                </section>

                {/* Itinerary */}
                <section className="detail-section">
                    <h2>Itinerary</h2>
                    <div className="itinerary-list">
                        {tour.itinerary.map((day) => (
                            <div key={day.day} className="itinerary-item">
                                <div className="itinerary-day">Day {day.day}</div>
                                <div className="itinerary-content">
                                    <h4>{day.title}</h4>
                                    <p>{day.description}</p>
                                </div>
                            </div>
                        ))}
                    </div>
                </section>

                {/* CTA Section */}
                <section className="detail-section cta-section">
                    <h2>Ready to Book?</h2>
                    <p>Contact us to reserve your spot on this tour.</p>
                    <div className="cta-buttons">
                        <button 
                            className="btn btn-primary btn-lg" 
                            onClick={() => navigate(`/booking/${tour.id}`)}
                        >
                            Book Now
                        </button>
                        <button className="btn btn-outline btn-lg">Request a Quote</button>
                    </div>
                </section>
            </div>
        </div>
    );
}