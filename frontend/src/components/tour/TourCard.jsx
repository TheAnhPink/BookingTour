import './../../styles/tour.css';
import { Link } from 'react-router-dom';

export default function TourCard({ tour }) {
    return (
        <div className="tour-card-horizontal">
            {/* Cột trái: Hình ảnh */}
            <div className="tour-card-img">
                <img src={tour.image} alt={tour.title} />
                {tour.badge && <span className="tour-badge">{tour.badge}</span>}
            </div>

            {/* Cột phải: Thông tin */}
            <div className="tour-card-info">
                <div className="tour-card-top">
                    <span className="tour-location">📍 {tour.location}</span>
                    <span className="tour-duration">⏱ {tour.duration}</span>
                </div>
                
                <h3 className="tour-title">{tour.title}</h3>
                
                <div className="tour-rating">
                    <span className="stars">★★★★★</span>
                    <span className="rating-score">{tour.rating}</span>
                    <span className="review-count">({tour.reviews} reviews)</span>
                </div>

                <div className="tour-card-bottom">
                    <div className="tour-price">
                        <span>From</span>
                        <strong>${tour.price}</strong>
                        <span>per person</span>
                    </div>
                    <Link to={`/tour/${tour.id}`} className="btn-view-tour" style={{ textDecoration: 'none', textAlign: 'center' }}>
                        View Tour
                    </Link>
                </div>
            </div>
        </div>
    );
}