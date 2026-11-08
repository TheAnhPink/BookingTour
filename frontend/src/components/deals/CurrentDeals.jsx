import { mockDeals } from '../../data/mockDeals';
import DealCard from './DealCard';

export default function CurrentDeals() {
    return (
        <section className="section current-deals">
            <div className="container">
                <div className="section-header">
                    <h2>Find Current Guided Tour Deals</h2>
                    <p>Explore current limited-time savings on select guided tours, including discounted departures, seasonal promotions, and special offers on specific itineraries.</p>
                </div>
                <div className="deals-grid">
                    {mockDeals.map((deal) => (
                        <DealCard key={deal.id} deal={deal} />
                    ))}
                </div>
            </div>
        </section>
    );
}