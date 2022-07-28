export class Race{
    
    constructor(
        private _season: string,
        private _round: string,
        private _url: string,
        private _raceName: string,
        private _date: string,
        private _time: string,
        private _Circuit: any,
        private _Results: any
    ){}
    
    public get Results(): any {
        return this._Results;
    }
    public set Results(value: any) {
        this._Results = value;
    }
    public get Circuit(): any {
        return this._Circuit;
    }
    public set Circuit(value: any) {
        this._Circuit = value;
    }
    public get time(): string {
        return this._time;
    }
    public set time(value: string) {
        this._time = value;
    }
    public get date(): string {
        return this._date;
    }
    public set date(value: string) {
        this._date = value;
    }
    public get raceName(): string {
        return this._raceName;
    }
    public set raceName(value: string) {
        this._raceName = value;
    }
    public get url(): string {
        return this._url;
    }
    public set url(value: string) {
        this._url = value;
    }
    public get round(): string {
        return this._round;
    }
    public set round(value: string) {
        this._round = value;
    }
    public get season(): string {
        return this._season;
    }
    public set season(value: string) {
        this._season = value;
    }

   

   public toJSON(): object {
        return {
            season: this._season,
            round: this._round,
            url: this._url,
            raceName: this._raceName,
            date: this._date,
            time: this._time,
            Circuit: this._Circuit,
            Results: this._Results
        };
    }
}