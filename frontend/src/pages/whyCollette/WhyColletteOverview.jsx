import { whyColletteData } from '../../data/whyColletteData';
import StyleHero from '../../components/travelStyle/StyleHero';
import StyleInfoBar from '../../components/travelStyle/StyleInfoBar';
import StyleFeatures from '../../components/travelStyle/StyleFeatures';
import StyleMoments from '../../components/travelStyle/StyleMoments';
import StyleCTA from '../../components/travelStyle/StyleCTA';
import '../../styles/travelStyle.css';

export default function WhyColletteOverview() {
    const data = whyColletteData['why-collette'];
    return (
        <div className="travel-style-page">
            <StyleHero title={data.title} tagline={data.tagline} image={data.heroImage} />
            <StyleInfoBar groupSize={data.groupSize} activityLevel={data.activityLevel} whatToExpect={data.whatToExpect} />
            <StyleFeatures title={data.title} features={data.features} />
            <StyleMoments title={data.title} moments={data.moments} />
            <StyleCTA title={data.title} />
        </div>
    );
}