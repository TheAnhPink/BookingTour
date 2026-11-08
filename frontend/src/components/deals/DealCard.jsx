import './../../styles/deals.css';

export default function DealCard({ deal }) {
    return (
        <div className="deal-card">
            <div className="deal-card-img">
                <img src={deal.image} alt={deal.title} />
                <span className="deal-badge">{deal.badge}</span>
            </div>
            <div className="deal-card-info">
                <div className="deal-card-top">
                    <span>📍 {deal.location}</span>
                    <span>⏱ {deal.duration}</span>
                </div>
                <h3>{deal.title}</h3>
                <div className="deal-rating">
                    <span className="stars">★★★★★</span>
                    <span>{deal.rating} ({deal.reviews} reviews)</span>
                </div>
                <div className="deal-price-row">
                    <div className="deal-price">
                        <span className="old-price">${deal.originalPrice}</span>
                        <span className="new-price">${deal.dealPrice}</span>
                        <span className="per-person">per person</span>
                    </div>
                    <button className="btn-view-deal">View Deal</button>
                </div>
            </div>
        </div>
    );
}