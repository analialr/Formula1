export class Driver{

    constructor(
        private _driverId: string,
        private _givenName: string,
        private _familyName: string,
        private _dateOfBirth: Date,
        private _nationality: string,
        private _url: string
    ){}

    public get url() {
        return this._url;
    }
    public set url(value) {
        this._url = value;
    }
    public get nationality() {
        return this._nationality;
    }
    public set nationality(value) {
        this._nationality = value;
    }
    public get dateOfBirth() {
        return this._dateOfBirth;
    }
    public set dateOfBirth(value) {
        this._dateOfBirth = value;
    }
    public get familyName() {
        return this._familyName;
    }
    public set familyName(value) {
        this._familyName = value;
    }
    public get givenName() {
        return this._givenName;
    }
    public set givenName(value) {
        this._givenName = value;
    }
    public get driverId() {
        return this._driverId;
    }
    public set driverId(value) {
        this._driverId = value;
    }

   public toJSON(): object {
        return {
            driverId: this._driverId, 
            givenName: this._givenName,
            familyName: this.familyName,
            dateOfBirth: this._dateOfBirth,
            nationality: this.nationality,
            url: this.url
        };
    }
}