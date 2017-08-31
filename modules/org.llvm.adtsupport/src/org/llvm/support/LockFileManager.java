/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std_time.nanosleep;
import org.clank.java.std_time.timespec;
import static org.clank.java.unistd.getpid;
import static org.clank.java.unistd.getsid;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.impl.*;
import org.llvm.support.sys.*;
import org.llvm.adt.*;
import static org.llvm.support.llvm.$eq_StringRef;

/// \brief Class that manages the creation of a lock file to aid
/// implicit coordination between different processes.
///
/// The implicit coordination works by creating a ".lock" file alongside
/// the file that we're coordinating for, using the atomicity of the file
/// system to ensure that only a single process can create that ".lock" file.
/// When the lock file is removed, the owning process has finished the
/// operation.
//<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", line = 28,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", old_line = 27,
 FQN="llvm::LockFileManager", NM="_ZN4llvm15LockFileManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManagerE")
//</editor-fold>
public class LockFileManager implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Describes the state of a lock file.
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::LockFileState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", line = 31,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", old_line = 30,
   FQN="llvm::LockFileManager::LockFileState", NM="_ZN4llvm15LockFileManager13LockFileStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManager13LockFileStateE")
  //</editor-fold>
  public enum LockFileState implements Native.NativeUIntEnum {
    /// \brief The lock file has been created and is owned by this instance
    /// of the object.
    LFS_Owned(0),
    /// \brief The lock file already exists and is owned by some other
    /// instance.
    LFS_Shared(LFS_Owned.getValue() + 1),
    /// \brief An error occurred while trying to create or find the lock
    /// file.
    LFS_Error(LFS_Shared.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LockFileState valueOf(int val) {
      LockFileState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LockFileState[] VALUES;
      private static final LockFileState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LockFileState kind : LockFileState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LockFileState[min < 0 ? (1-min) : 0];
        VALUES = new LockFileState[max >= 0 ? (1+max) : 0];
        for (LockFileState kind : LockFileState.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private LockFileState(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Describes the result of waiting for the owner to release the lock.
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::WaitForUnlockResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", line = 44,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", old_line = 43,
   FQN="llvm::LockFileManager::WaitForUnlockResult", NM="_ZN4llvm15LockFileManager19WaitForUnlockResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManager19WaitForUnlockResultE")
  //</editor-fold>
  public enum WaitForUnlockResult implements Native.NativeUIntEnum {
    /// \brief The lock was released successfully.
    Res_Success(0),
    /// \brief Owner died while holding the lock.
    Res_OwnerDied(Res_Success.getValue() + 1),
    /// \brief Reached timeout while waiting for the owner to release the lock.
    Res_Timeout(Res_OwnerDied.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static WaitForUnlockResult valueOf(int val) {
      WaitForUnlockResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final WaitForUnlockResult[] VALUES;
      private static final WaitForUnlockResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (WaitForUnlockResult kind : WaitForUnlockResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new WaitForUnlockResult[min < 0 ? (1-min) : 0];
        VALUES = new WaitForUnlockResult[max >= 0 ? (1+max) : 0];
        for (WaitForUnlockResult kind : WaitForUnlockResult.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private WaitForUnlockResult(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private SmallString/*<128>*/ FileName;
  private SmallString/*<128>*/ LockFileName;
  private SmallString/*<128>*/ UniqueLockFileName;
  
  private Optional<std.pairTypeInt<std.string> > Owner;
  private Optional<std.error_code> Error;
  private std.string ErrorDiagMsg;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::LockFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", line = 62,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", old_line = 60,
   FQN="llvm::LockFileManager::LockFileManager", NM="_ZN4llvm15LockFileManagerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManagerC1ERKS0_")
  //</editor-fold>
  protected/*private*/ LockFileManager(final /*const*/ LockFileManager /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", line = 63,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", old_line = 61,
   FQN="llvm::LockFileManager::operator=", NM="_ZN4llvm15LockFileManageraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManageraSERKS0_")
  //</editor-fold>
  protected/*private*/ LockFileManager /*&*/ $assign(final /*const*/ LockFileManager /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  
  /// \brief Attempt to read the lock file with the given name, if it exists.
  ///
  /// \param LockFileName The name of the lock file to read.
  ///
  /// \returns The process ID of the process that owns this lock file
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::readLockFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 41,
   FQN="llvm::LockFileManager::readLockFile", NM="_ZN4llvm15LockFileManager12readLockFileENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManager12readLockFileENS_9StringRefE")
  //</editor-fold>
  private static Optional<std.pairTypeInt<std.string> > readLockFile(StringRef LockFileName) {
    ErrorOr<std.unique_ptr<MemoryBuffer> > MBOrErr = null;
    try {
      // Read the owning host and PID out of the lock file. If it appears that the
      // owning process is dead, the lock file is invalid.
      MBOrErr = MemoryBuffer.getFile(new Twine(LockFileName));
      if (!MBOrErr.$bool()) {
        fs.remove(new Twine(LockFileName));
        return new Optional<std.pairTypeInt<std.string> >(llvm.None);
      }
      final MemoryBuffer /*&*/ MB = MBOrErr.get().$star();
      
      StringRef Hostname/*J*/= new StringRef();
      StringRef PIDStr/*J*/= new StringRef();
      std.tie(Hostname, PIDStr).$assign(llvm.getToken(MB.getBuffer(), new StringRef(/*KEEP_STR*/$SPACE)));
      PIDStr.$assignMove(PIDStr.substr(PIDStr.find_first_not_of(/*STRINGREF_STR*/" ")));
      int$ref PID = create_int$ref();
      if (!PIDStr.getAsInteger$Signed(10, PID)) {
        std.pairTypeInt<std.string> Owner = std.make_pair_T_int($Move(Hostname.$string()), PID);
        if (processStillExecuting(new StringRef(Owner.first), Owner.second)) {
          return new Optional<std.pairTypeInt<std.string> >(JD$T$RR.INSTANCE, Owner);
        }
      }
      
      // Delete the lock file. It's invalid anyway.
      fs.remove(new Twine(LockFileName));
      return new Optional<std.pairTypeInt<std.string> >(llvm.None);
    } finally {
      if (MBOrErr != null) { MBOrErr.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::processStillExecuting">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 100,
   FQN="llvm::LockFileManager::processStillExecuting", NM="_ZN4llvm15LockFileManager21processStillExecutingENS_9StringRefEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManager21processStillExecutingENS_9StringRefEi")
  //</editor-fold>
  private static boolean processStillExecuting(StringRef HostID, int PID) {
    SmallString/*<256>*/ StoredHostID/*J*/= new SmallString/*<256>*/(256);
    if (LockFileManagerStatics.getHostID(StoredHostID).$bool()) {
      return true; // Conservatively assume it's executing on error.
    }
    
    // Check whether the process is dead. If so, we're done.
    if ($eq_StringRef(StoredHostID.$StringRef(), /*NO_COPY*/HostID) && getsid(PID) == -1 && errno() == ESRCH) {
      return false;
    }
    
    return true;
  }

/*public:*/
  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::LockFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 143,
   FQN="llvm::LockFileManager::LockFileManager", NM="_ZN4llvm15LockFileManagerC1ENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManagerC1ENS_9StringRefE")
  //</editor-fold>
  public LockFileManager(StringRef FileName) {
    // : FileName(), LockFileName(), UniqueLockFileName(), Owner(), Error(), ErrorDiagMsg() 
    //START JInit
    this.FileName = new SmallString/*<128>*/(128);
    this.LockFileName = new SmallString/*<128>*/(128);
    this.UniqueLockFileName = new SmallString/*<128>*/(128);
    this.Owner = new Optional<std.pairTypeInt<std.string> >();
    this.Error = new Optional<std.error_code>();
    this.ErrorDiagMsg = new std.string();
    //END JInit
    RemoveUniqueLockFileOnSignal RemoveUniqueFile = null;
    try {
      this.FileName.$assign(/*NO_COPY*/FileName);
      {
        std.error_code EC = fs.make_absolute(this.FileName);
        if (EC.$bool()) {
          std.string S/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"failed to obtain absolute path for ");
          S.append(this.FileName.str().$string());
          setError(EC, new StringRef(S));
          return;
        }
      }
      LockFileName.$assign(this.FileName);
      LockFileName.$addassign(/*STRINGREF_STR*/".lock");
      
      // If the lock file already exists, don't bother to try to create our own
      // lock file; it won't work anyway. Just figure out who owns this lock file.
      if ((Owner.$assignMove(readLockFile(LockFileName.$StringRef()))).$bool()) {
        return;
      }
      
      // Create a lock file that is unique to this instance.
      UniqueLockFileName.$assign(LockFileName);
      UniqueLockFileName.$addassign(/*STRINGREF_STR*/"-%%%%%%%%");
      int$ref UniqueLockFileID = create_int$ref();
      {
        std.error_code EC = fs.createUniqueFile(new Twine(UniqueLockFileName), UniqueLockFileID, UniqueLockFileName);
        if (EC.$bool()) {
          std.string S/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"failed to create unique file ");
          S.append(UniqueLockFileName.str().$string());
          setError(EC, new StringRef(S));
          return;
        }
      }
      {
        raw_fd_ostream Out = null;
        try {
          SmallString/*<256>*/ HostID/*J*/= new SmallString/*<256>*/(256);
          {
            std.error_code EC = LockFileManagerStatics.getHostID(HostID);
            if (EC.$bool()) {
              setError(EC, new StringRef(/*KEEP_STR*/"failed to get host id"));
              return;
            }
          }
          
          Out/*J*/= new raw_fd_ostream(UniqueLockFileID.$deref(), /*shouldClose=*/ true);
          Out.$out(HostID).$out_char($$SPACE);
          Out.$out_int(getpid());
          Out.close();
          if (Out.has_error()) {
            // We failed to write out PID, so make up an excuse, remove the
            // unique lock file, and fail.
            std.error_code EC = AdtsupportLlvmGlobals.make_error_code(errc.no_space_on_device);
            std.string S/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"failed to write to ");
            S.append(UniqueLockFileName.str().$string());
            setError(EC, new StringRef(S));
            fs.remove(new Twine(UniqueLockFileName));
            return;
          }
        } finally {
          if (Out != null) { Out.$destroy(); }
        }
      }
      
      // Clean up the unique file on signal, which also releases the lock if it is
      // held since the .lock symlink will point to a nonexistent file.
      RemoveUniqueFile/*J*/= new RemoveUniqueLockFileOnSignal(UniqueLockFileName.$StringRef());
      while (true) {
        // Create a link from the lock file name. If this succeeds, we're done.
        std.error_code EC = fs.create_link(new Twine(UniqueLockFileName), new Twine(LockFileName));
        if (!EC.$bool()) {
          RemoveUniqueFile.lockAcquired();
          return;
        }
        if ($noteq_error_code$C(EC, new std.error_code(errc.file_exists))) {
          raw_string_ostream OSS = null;
          try {
            std.string S/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"failed to create link ");
            OSS/*J*/= new raw_string_ostream(S);
            OSS.$out(LockFileName.str()).$out(/*KEEP_STR*/" to ").$out(UniqueLockFileName.str());
            setError(EC, new StringRef(OSS.str()));
            return;
          } finally {
            if (OSS != null) { OSS.$destroy(); }
          }
        }
        
        // Someone else managed to create the lock file first. Read the process ID
        // from the lock file.
        if ((Owner.$assignMove(readLockFile(LockFileName.$StringRef()))).$bool()) {
          // Wipe out our unique lock file (it's useless now)
          fs.remove(new Twine(UniqueLockFileName));
          return;
        }
        if (!fs.exists(new Twine(LockFileName))) {
          // The previous owner released the lock file before we could read it.
          // Try to get ownership again.
          continue;
        }
        
        // There is a lock file that nobody owns; try to clean it up and get
        // ownership.
        if ((EC.$assignMove(fs.remove(new Twine(LockFileName)))).$bool()) {
          std.string S/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"failed to remove lockfile ");
          S.append(UniqueLockFileName.str().$string());
          setError(EC, new StringRef(S));
          return;
        }
      }
    } finally {
      if (RemoveUniqueFile != null) { RemoveUniqueFile.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::~LockFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 270,
   old_source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", old_line = 245,
   FQN="llvm::LockFileManager::~LockFileManager", NM="_ZN4llvm15LockFileManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (getState() != LockFileState.LFS_Owned) {
      return;
    }
    
    // Since we own the lock, remove the lock file and our own unique lock file.
    fs.remove(new Twine(LockFileName));
    fs.remove(new Twine(UniqueLockFileName));
    // The unique file is now gone, so remove it from the signal handler. This
    // matches a sys::RemoveFileOnSignal() in LockFileManager().
    sys.DontRemoveFileOnSignal(UniqueLockFileName.$StringRef());
    //START JDestroy
    ErrorDiagMsg.$destroy();
    Error.$destroy();
    Owner.$destroy();
    UniqueLockFileName.$destroy();
    LockFileName.$destroy();
    FileName.$destroy();
    //END JDestroy
  }

  
  /// \brief Determine the state of the lock file.
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 247,
   old_source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", old_line = 235,
   FQN="llvm::LockFileManager::getState", NM="_ZNK4llvm15LockFileManager8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZNK4llvm15LockFileManager8getStateEv")
  //</editor-fold>
  public LockFileManager.LockFileState getState() /*const*/ {
    if (Owner.$bool()) {
      return LockFileState.LFS_Shared;
    }
    if (Error.$bool()) {
      return LockFileState.LFS_Error;
    }
    
    return LockFileState.LFS_Owned;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::operator LockFileState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", old_line = 76,
   FQN="llvm::LockFileManager::operator LockFileState", NM="_ZNK4llvm15LockFileManagercvNS0_13LockFileStateEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZNK4llvm15LockFileManagercvNS0_13LockFileStateEEv")
  //</editor-fold>
  public LockFileState $LockFileState() /*const*/ {
    return getState();
  }

  
  /// \brief For a shared lock, wait until the owner releases the lock.
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::waitForUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 282,
   old_source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", old_line = 257,
   FQN="llvm::LockFileManager::waitForUnlock", NM="_ZN4llvm15LockFileManager13waitForUnlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManager13waitForUnlockEv")
  //</editor-fold>
  public LockFileManager.WaitForUnlockResult waitForUnlock() {
    if (getState() != LockFileState.LFS_Shared) {
      return WaitForUnlockResult.Res_Success;
    }
     timespec Interval/*J*/= new  timespec();
    Interval.tv_sec = 0;
    Interval.tv_nsec = 1000000;
    // Don't wait more than five minutes per iteration. Total timeout for the file
    // to appear is ~8.5 mins.
    /*const*//*uint*/int MaxSeconds = 5 * 60;
    do {
      nanosleep($AddrOf(Interval), ( timespec /*P*/ )null);
      if ($eq_error_code$C(fs.access(new Twine(LockFileName.c_str()), fs.AccessMode.Exist), 
          new std.error_code(errc.no_such_file_or_directory))) {
        // If the original file wasn't created, somone thought the lock was dead.
        if (!fs.exists(new Twine(FileName))) {
          return WaitForUnlockResult.Res_OwnerDied;
        }
        return WaitForUnlockResult.Res_Success;
      }
      
      // If the process owning the lock died without cleaning up, just bail out.
      if (!processStillExecuting(new StringRef((Owner.$star()).first), (Owner.$star()).second)) {
        return WaitForUnlockResult.Res_OwnerDied;
      }
      Interval.tv_sec *= 2;
      Interval.tv_nsec *= 2;
      if (Interval.tv_nsec >= 1000000000) {
        ++Interval.tv_sec;
        Interval.tv_nsec -= 1000000000;
      }
    } while (Interval.tv_sec < (long/*time_t*/)MaxSeconds);
    
    // Give up.
    return WaitForUnlockResult.Res_Timeout;
  }

  
  /// \brief Remove the lock file.  This may delete a different lock file than
  /// the one previously read if there is a race.
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::unsafeRemoveLockFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 342,
   old_source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", old_line = 317,
   FQN="llvm::LockFileManager::unsafeRemoveLockFile", NM="_ZN4llvm15LockFileManager20unsafeRemoveLockFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManager20unsafeRemoveLockFileEv")
  //</editor-fold>
  public std.error_code unsafeRemoveLockFile() {
    return fs.remove(new Twine(LockFileName));
  }

  
  /// \brief Get error message, or "" if there is no error.
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::getErrorMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp", line = 257,
   FQN="llvm::LockFileManager::getErrorMessage", NM="_ZNK4llvm15LockFileManager15getErrorMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZNK4llvm15LockFileManager15getErrorMessageEv")
  //</editor-fold>
  public std.string getErrorMessage() /*const*/ {
    if (Error.$bool()) {
      raw_string_ostream OSS = null;
      try {
        std.string Str/*J*/= new std.string(ErrorDiagMsg);
        std.string ErrCodeMsg = Error.$arrow$Const().message();
        OSS/*J*/= new raw_string_ostream(Str);
        if (!ErrCodeMsg.empty()) {
          OSS.$out(/*KEEP_STR*/": ").$out(Error.$arrow$Const().message());
        }
        OSS.flush();
        return Str;
      } finally {
        if (OSS != null) { OSS.$destroy(); }
      }
    }
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }

  
  /// \brief Set error and error message
  //<editor-fold defaultstate="collapsed" desc="llvm::LockFileManager::setError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LockFileManager.h", line = 91,
   FQN="llvm::LockFileManager::setError", NM="_ZN4llvm15LockFileManager8setErrorERSt10error_codeNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LockFileManager.cpp -nm=_ZN4llvm15LockFileManager8setErrorERSt10error_codeNS_9StringRefE")
  //</editor-fold>
  public void setError(final std.error_code /*&*/ EC) {
    setError(EC, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public void setError(final std.error_code /*&*/ EC, StringRef ErrorMsg/*= ""*/) {
    Error.$assign_T$C$R(EC);
    ErrorDiagMsg.$assignMove(ErrorMsg.str());
  }

  
  @Override public String toString() {
    return "" + "FileName=" + FileName // NOI18N
              + ", LockFileName=" + LockFileName // NOI18N
              + ", UniqueLockFileName=" + UniqueLockFileName // NOI18N
              + ", Owner=" + Owner // NOI18N
              + ", Error=" + Error // NOI18N
              + ", ErrorDiagMsg=" + ErrorDiagMsg; // NOI18N
  }
}
