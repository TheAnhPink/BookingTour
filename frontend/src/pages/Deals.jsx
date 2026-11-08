import DealsHero from '../components/deals/DealsHero';
import RegionDeals from '../components/deals/RegionDeals';
import CurrentDeals from '../components/deals/CurrentDeals';
import PeaceOfMind from '../components/deals/PeaceOfMind';
import MoreWaysToSave from '../components/deals/MoreWaysToSave';
import '../styles/deals.css';

export default function Deals() {
    return (
        <div className="deals-page">
            <DealsHero />
            <RegionDeals />
            <CurrentDeals />
            <PeaceOfMind />
            <MoreWaysToSave />
        </div>
    );
}