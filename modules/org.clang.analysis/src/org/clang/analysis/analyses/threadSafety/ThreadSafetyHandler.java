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

package org.clang.analysis.analyses.threadSafety;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// Handler class for thread safety warnings.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 73,
 FQN="clang::threadSafety::ThreadSafetyHandler", NM="_ZN5clang12threadSafety19ThreadSafetyHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandlerE")
//</editor-fold>
public class ThreadSafetyHandler implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef StringRef Name*/
//  public final class Name extends StringRef{ };
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::ThreadSafetyHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 76,
   FQN="clang::threadSafety::ThreadSafetyHandler::ThreadSafetyHandler", NM="_ZN5clang12threadSafety19ThreadSafetyHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandlerC1Ev")
  //</editor-fold>
  public ThreadSafetyHandler() {
    // : IssueBetaWarnings(false) 
    //START JInit
    this.IssueBetaWarnings = false;
    //END JInit
  }

  
  // Key method definition
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::~ThreadSafetyHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 51,
   FQN="clang::threadSafety::ThreadSafetyHandler::~ThreadSafetyHandler", NM="_ZN5clang12threadSafety19ThreadSafetyHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandlerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// Warn about lock expressions which fail to resolve to lockable objects.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param Loc -- the SourceLocation of the unresolved expression.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleInvalidLockExp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 82,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleInvalidLockExp", NM="_ZN5clang12threadSafety19ThreadSafetyHandler20handleInvalidLockExpEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler20handleInvalidLockExpEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleInvalidLockExp(StringRef Kind, SourceLocation Loc) {
  }

  
  /// Warn about unlock function calls that do not have a prior matching lock
  /// expression.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param LockName -- A StringRef name for the lock expression, to be printed
  /// in the error message.
  /// \param Loc -- The SourceLocation of the Unlock
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleUnmatchedUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 90,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleUnmatchedUnlock", NM="_ZN5clang12threadSafety19ThreadSafetyHandler21handleUnmatchedUnlockEN4llvm9StringRefES3_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler21handleUnmatchedUnlockEN4llvm9StringRefES3_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleUnmatchedUnlock(StringRef Kind, StringRef LockName, 
                       SourceLocation Loc) {
  }

  
  /// Warn about an unlock function call that attempts to unlock a lock with
  /// the incorrect lock kind. For instance, a shared lock being unlocked
  /// exclusively, or vice versa.
  /// \param LockName -- A StringRef name for the lock expression, to be printed
  /// in the error message.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param Expected -- the kind of lock expected.
  /// \param Received -- the kind of lock received.
  /// \param Loc -- The SourceLocation of the Unlock.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleIncorrectUnlockKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 102,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleIncorrectUnlockKind", NM="_ZN5clang12threadSafety19ThreadSafetyHandler25handleIncorrectUnlockKindEN4llvm9StringRefES3_NS0_8LockKindES4_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler25handleIncorrectUnlockKindEN4llvm9StringRefES3_NS0_8LockKindES4_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleIncorrectUnlockKind(StringRef Kind, StringRef LockName, 
                           LockKind Expected, LockKind Received, 
                           SourceLocation Loc) {
  }

  
  /// Warn about lock function calls for locks which are already held.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param LockName -- A StringRef name for the lock expression, to be printed
  /// in the error message.
  /// \param Loc -- The location of the second lock expression.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleDoubleLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 111,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleDoubleLock", NM="_ZN5clang12threadSafety19ThreadSafetyHandler16handleDoubleLockEN4llvm9StringRefES3_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler16handleDoubleLockEN4llvm9StringRefES3_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleDoubleLock(StringRef Kind, StringRef LockName, 
                  SourceLocation Loc) {
  }

  
  /// Warn about situations where a mutex is sometimes held and sometimes not.
  /// The three situations are:
  /// 1. a mutex is locked on an "if" branch but not the "else" branch,
  /// 2, or a mutex is only held at the start of some loop iterations,
  /// 3. or when a mutex is locked but not unlocked inside a function.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param LockName -- A StringRef name for the lock expression, to be printed
  /// in the error message.
  /// \param LocLocked -- The location of the lock expression where the mutex is
  ///               locked
  /// \param LocEndOfScope -- The location of the end of the scope where the
  ///               mutex is no longer held
  /// \param LEK -- which of the three above cases we should warn for
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleMutexHeldEndOfScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 127,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleMutexHeldEndOfScope", NM="_ZN5clang12threadSafety19ThreadSafetyHandler25handleMutexHeldEndOfScopeEN4llvm9StringRefES3_NS_14SourceLocationES4_NS0_13LockErrorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler25handleMutexHeldEndOfScopeEN4llvm9StringRefES3_NS_14SourceLocationES4_NS0_13LockErrorKindE")
  //</editor-fold>
  public /*virtual*/ void handleMutexHeldEndOfScope(StringRef Kind, StringRef LockName, 
                           SourceLocation LocLocked, 
                           SourceLocation LocEndOfScope, 
                           LockErrorKind LEK) {
  }

  
  /// Warn when a mutex is held exclusively and shared at the same point. For
  /// example, if a mutex is locked exclusively during an if branch and shared
  /// during the else branch.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param LockName -- A StringRef name for the lock expression, to be printed
  /// in the error message.
  /// \param Loc1 -- The location of the first lock expression.
  /// \param Loc2 -- The location of the second lock expression.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleExclusiveAndShared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 140,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleExclusiveAndShared", NM="_ZN5clang12threadSafety19ThreadSafetyHandler24handleExclusiveAndSharedEN4llvm9StringRefES3_NS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler24handleExclusiveAndSharedEN4llvm9StringRefES3_NS_14SourceLocationES4_")
  //</editor-fold>
  public /*virtual*/ void handleExclusiveAndShared(StringRef Kind, StringRef LockName, 
                          SourceLocation Loc1, 
                          SourceLocation Loc2) {
  }

  
  /// Warn when a protected operation occurs while no locks are held.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param D -- The decl for the protected variable or function
  /// \param POK -- The kind of protected operation (e.g. variable access)
  /// \param AK -- The kind of access (i.e. read or write) that occurred
  /// \param Loc -- The location of the protected operation.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleNoMutexHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 150,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleNoMutexHeld", NM="_ZN5clang12threadSafety19ThreadSafetyHandler17handleNoMutexHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindENS0_10AccessKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler17handleNoMutexHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindENS0_10AccessKindENS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleNoMutexHeld(StringRef Kind, /*const*/ NamedDecl /*P*/ D, 
                   ProtectedOperationKind POK, AccessKind AK, 
                   SourceLocation Loc) {
  }

  
  /// Warn when a protected operation occurs while the specific mutex protecting
  /// the operation is not locked.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param D -- The decl for the protected variable or function
  /// \param POK -- The kind of protected operation (e.g. variable access)
  /// \param LockName -- A StringRef name for the lock expression, to be printed
  /// in the error message.
  /// \param LK -- The kind of access (i.e. read or write) that occurred
  /// \param Loc -- The location of the protected operation.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleMutexNotHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 163,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleMutexNotHeld", NM="_ZN5clang12threadSafety19ThreadSafetyHandler18handleMutexNotHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindES3_NS0_8LockKindENS_14SourceLocationEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler18handleMutexNotHeldEN4llvm9StringRefEPKNS_9NamedDeclENS0_22ProtectedOperationKindES3_NS0_8LockKindENS_14SourceLocationEPS3_")
  //</editor-fold>
  public /*virtual*/ void handleMutexNotHeld(StringRef Kind, /*const*/ NamedDecl /*P*/ D, 
                    ProtectedOperationKind POK, StringRef LockName, 
                    LockKind LK, SourceLocation Loc) {
    handleMutexNotHeld(Kind, D, 
                    POK, LockName, 
                    LK, Loc, 
                    (StringRef /*P*/ )null);
  }
  public /*virtual*/ void handleMutexNotHeld(StringRef Kind, /*const*/ NamedDecl /*P*/ D, 
                    ProtectedOperationKind POK, StringRef LockName, 
                    LockKind LK, SourceLocation Loc, 
                    StringRef /*P*/ PossibleMatch/*= null*/) {
  }

  
  /// Warn when acquiring a lock that the negative capability is not held.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param LockName -- The name for the lock expression, to be printed in the
  /// diagnostic.
  /// \param Neg -- The name of the negative capability to be printed in the
  /// diagnostic.
  /// \param Loc -- The location of the protected operation.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleNegativeNotHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 175,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleNegativeNotHeld", NM="_ZN5clang12threadSafety19ThreadSafetyHandler21handleNegativeNotHeldEN4llvm9StringRefES3_S3_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler21handleNegativeNotHeldEN4llvm9StringRefES3_S3_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleNegativeNotHeld(StringRef Kind, StringRef LockName, StringRef Neg, 
                       SourceLocation Loc) {
  }

  
  /// Warn when a function is called while an excluded mutex is locked. For
  /// example, the mutex may be locked inside the function.
  /// \param Kind -- the capability's name parameter (role, mutex, etc).
  /// \param FunName -- The name of the function
  /// \param LockName -- A StringRef name for the lock expression, to be printed
  /// in the error message.
  /// \param Loc -- The location of the function call.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleFunExcludesLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 185,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleFunExcludesLock", NM="_ZN5clang12threadSafety19ThreadSafetyHandler21handleFunExcludesLockEN4llvm9StringRefES3_S3_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler21handleFunExcludesLockEN4llvm9StringRefES3_S3_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleFunExcludesLock(StringRef Kind, StringRef FunName, 
                       StringRef LockName, SourceLocation Loc) {
  }

  
  /// Warn that L1 cannot be acquired before L2.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleLockAcquiredBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 190,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleLockAcquiredBefore", NM="_ZN5clang12threadSafety19ThreadSafetyHandler24handleLockAcquiredBeforeEN4llvm9StringRefES3_S3_NS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler24handleLockAcquiredBeforeEN4llvm9StringRefES3_S3_NS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleLockAcquiredBefore(StringRef Kind, StringRef L1Name, 
                          StringRef L2Name, SourceLocation Loc) {
  }

  
  /// Warn that there is a cycle in acquired_before/after dependencies.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::handleBeforeAfterCycle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 194,
   FQN="clang::threadSafety::ThreadSafetyHandler::handleBeforeAfterCycle", NM="_ZN5clang12threadSafety19ThreadSafetyHandler22handleBeforeAfterCycleEN4llvm9StringRefENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler22handleBeforeAfterCycleEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  public /*virtual*/ void handleBeforeAfterCycle(StringRef L1Name, SourceLocation Loc) {
  }

  
  /// Called by the analysis when starting analysis of a function.
  /// Used to issue suggestions for changes to annotations.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::enterFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 198,
   FQN="clang::threadSafety::ThreadSafetyHandler::enterFunction", NM="_ZN5clang12threadSafety19ThreadSafetyHandler13enterFunctionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler13enterFunctionEPKNS_12FunctionDeclE")
  //</editor-fold>
  public /*virtual*/ void enterFunction(/*const*/ FunctionDecl /*P*/ FD) {
  }

  
  /// Called by the analysis when finishing analysis of a function.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::leaveFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 201,
   FQN="clang::threadSafety::ThreadSafetyHandler::leaveFunction", NM="_ZN5clang12threadSafety19ThreadSafetyHandler13leaveFunctionEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler13leaveFunctionEPKNS_12FunctionDeclE")
  //</editor-fold>
  public /*virtual*/ void leaveFunction(/*const*/ FunctionDecl /*P*/ FD) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::issueBetaWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 203,
   FQN="clang::threadSafety::ThreadSafetyHandler::issueBetaWarnings", NM="_ZN5clang12threadSafety19ThreadSafetyHandler17issueBetaWarningsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler17issueBetaWarningsEv")
  //</editor-fold>
  public boolean issueBetaWarnings() {
    return IssueBetaWarnings;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::ThreadSafetyHandler::setIssueBetaWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafety.h", line = 204,
   FQN="clang::threadSafety::ThreadSafetyHandler::setIssueBetaWarnings", NM="_ZN5clang12threadSafety19ThreadSafetyHandler20setIssueBetaWarningsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety19ThreadSafetyHandler20setIssueBetaWarningsEb")
  //</editor-fold>
  public void setIssueBetaWarnings(boolean b) {
    IssueBetaWarnings = b;
  }

/*private:*/
  private boolean IssueBetaWarnings;
  
  @Override public String toString() {
    return "" + "IssueBetaWarnings=" + IssueBetaWarnings; // NOI18N
  }
}
