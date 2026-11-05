import './../../styles/home.css';

const reviews = [
    {
        text: 'Just returned from the Treasures of South Africa tour, and it was the trip of a lifetime.',
        author: 'Melanie K.',
    },
    {
        text: 'This tour was awesome. Scenery is amazing. All wonderful. Put it on your bucket list!',
        author: 'Trusted Customer',
    },
    {
        text: 'The transportation, accommodations, and food were great. Highly recommended!',
        author: 'Trusted Customer',
    },
];

export default function ReviewsSection() {
    return (
        <section className="section reviews">
            <div className="container">
                <div className="reviews-header">
                    <h2>Collette Traveler Reviews</h2>
                    <div className="rating-badge">
                        <span className="rating-score">4.8</span>
                        <span className="rating-outof">out of 5</span>
                        <span className="rating-count">— backed by 32,688 lifetime reviews</span>
                    </div>
                </div>

                <div className="reviews-grid">
                    {reviews.map((r, idx) => (
                        <div key={idx} className="review-card">
                            <div className="review-stars">★★★★★</div>
                            <p className="review-text">“{r.text}”</p>
                            <p className="review-author">— {r.author}</p>
                        </div>
                    ))}
                </div>
            </div>
        </section>
    );
}