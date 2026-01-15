import psycopg2

# MERK: Må kjøres med Python 3

user = 'kristhaj@uio.no' # Sett inn ditt UiO-brukernavn ("_priv" blir lagt til under)
pwd = 'uo9Ieh0air' # Sett inn passordet for _priv-brukeren du fikk i en mail

connection = \
    "dbname='" + user + "' " +  \
    "user='" + user + "_priv' " + \
    "port='5432' " +  \
    "host='dbpg-ifi-kurs03.uio.no' " + \
    "password='" + pwd + "'"

def huffsa():
    conn = psycopg2.connect(connection)
    
    ch = 0
    while (ch != 3):
        print("--[ HUFFSA ]--")
        print("Vennligst velg et alternativ:\n 1. Søk etter planet\n 2. Legg inn forsøksresultat\n 3. Avslutt")
        ch = int(input("Valg: "))

        if (ch == 1):
            planet_sok(conn)
        elif (ch == 2):
            legg_inn_resultat(conn)
    
def planet_sok(conn):
    print("--[PLANET-SØK]")
    mol1 = str(input("Molekyl 1: "))
    mol2 = str(input("Molekyl 2: "))

    q1 = f'''
        SELECT * FROM materie
        JOIN planet
         ON materie.planet = planet.navn
        WHERE materie.molekyl = {mol1}
    '''
    
    print(f'''
            \n---[PLANET]---\n
            Navn: {None}\n
            Planet-masse: {None}\n
            Stjerne-masse: {None}\n
            Stjerne-distanse: {None}\n
            Bekreftet liv: {None}\n
          ''')

    curs = conn.cursor()
    curs.execute()


def legg_inn_resultat(conn):


if __name__ == "__main__":
    huffsa()
