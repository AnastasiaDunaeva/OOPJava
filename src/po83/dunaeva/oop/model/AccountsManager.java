package po83.dunaeva.oop.model;

public class AccountsManager {
    private int DEFAULT_SIZE = 8;
    private Account[] accounts;
    private int size;

    public AccountsManager(int size) {
        this.size = size;
        accounts = new Account[size];
    }

    public AccountsManager(Account[] accounts) {
        size = accounts.length;
        this.accounts = new Account[size()];
        System.arraycopy(accounts, 0, this.accounts, 0, size());
    }

    public boolean add(Account account) {
        for (int i = 0; i < size(); i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }
        doubleArraySize();
        return add(account);
    }

    public boolean add(int index, Account account) {
        if (accounts[index] == null) {
            accounts[index] = account;
            return true;
        } else {
            return false;
        }
    }

    public Account get(int index) {
        return accounts[index];
    }

    public Account get(long accountNumber) {
        for (int i = 0; i < size; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getNumber() == accountNumber) {
                    return accounts[i];
                }
            }
        }
        return null;
    }

    public boolean hasAccount(long accountNumber) {
        for (int i = 0; i < size; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getNumber() == accountNumber) {
                    return true;
                }
            }
        }
        return false;
    }

    public Account set(int index, Account account) {
        Account changedAccount = accounts[index];
        accounts[index] = account;
        return changedAccount;
    }

    public Account remove(int index) {
        Account removedAccount = accounts[index];
        System.arraycopy(accounts, index, accounts, index + 1, size - index - 1);
        accounts[size - index - 1] = null;
        return removedAccount;
    }

    public Account remove(long accountNumber) {
        for (int i = 0; i < size; i++) {
            if (accounts[i] != null)
                if (accounts[i].getNumber() == accountNumber) {
                    return remove(i);
                }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Account[] getAccounts() {
        Account[] result = new Account[size()];
        System.arraycopy(accounts, 0, result, 0, size());
        return result;
    }

    public Tariff getTariff(long accountNumber) {
        for (int i = 0; i < accountNumber; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getNumber() == accountNumber) {
                    return accounts[i].getTariff();
                }
            }
        }
        return null;
    }

    public Tariff setTariff(long accountNumber, Tariff tariff) {
        Tariff result = null;
        for (int i = 0; i < accountNumber; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getNumber() == accountNumber) {
                    result = accounts[i].getTariff();
                    accounts[i].setTariff(tariff);
                    break;
                }
            }
        }
        return result;
    }

    private void doubleArraySize() {
        Account[] result = new Account[size * 2];
        System.arraycopy(accounts, 0, result, 0, size());
        size *= 2;
        accounts = result;
    }
}
