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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// IVStrideUse - Keep track of one use of a strided induction variable.
/// The Expr member keeps track of the expression, User is the actual user
/// instruction of the operand, and 'OperandValToReplace' is the operand of
/// the User that is the use.
//<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 37,
 FQN="llvm::IVStrideUse", NM="_ZN4llvm11IVStrideUseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUseE")
//</editor-fold>
public final class IVStrideUse extends /*public*/ CallbackVH implements /*public*/ ilist_node<IVStrideUse>, Destructors.ClassWithDestructor {
  /*friend  class IVUsers*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::IVStrideUse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 40,
   FQN="llvm::IVStrideUse::IVStrideUse", NM="_ZN4llvm11IVStrideUseC1EPNS_7IVUsersEPNS_11InstructionEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUseC1EPNS_7IVUsersEPNS_11InstructionEPNS_5ValueE")
  //</editor-fold>
  public IVStrideUse(IVUsers /*P*/ P, Instruction /*P*/ U, Value /*P*/ O) {
    // : CallbackVH(U), ilist_node<IVStrideUse>(), Parent(P), OperandValToReplace(O), PostIncLoops() 
    super(U);
    this.ilist_node$Flds = $ilist_node();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getUser - Return the user instruction for this use.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::getUser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 45,
   FQN="llvm::IVStrideUse::getUser", NM="_ZNK4llvm11IVStrideUse7getUserEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm11IVStrideUse7getUserEv")
  //</editor-fold>
  public Instruction /*P*/ getUser() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// setUser - Assign a new user instruction for this use.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::setUser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 50,
   FQN="llvm::IVStrideUse::setUser", NM="_ZN4llvm11IVStrideUse7setUserEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUse7setUserEPNS_11InstructionE")
  //</editor-fold>
  public void setUser(Instruction /*P*/ NewUser) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getOperandValToReplace - Return the Value of the operand in the user
  /// instruction that this IVStrideUse is representing.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::getOperandValToReplace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 56,
   FQN="llvm::IVStrideUse::getOperandValToReplace", NM="_ZNK4llvm11IVStrideUse22getOperandValToReplaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm11IVStrideUse22getOperandValToReplaceEv")
  //</editor-fold>
  public Value /*P*/ getOperandValToReplace() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// setOperandValToReplace - Assign a new Value as the operand value
  /// to replace.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::setOperandValToReplace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 62,
   FQN="llvm::IVStrideUse::setOperandValToReplace", NM="_ZN4llvm11IVStrideUse22setOperandValToReplaceEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUse22setOperandValToReplaceEPNS_5ValueE")
  //</editor-fold>
  public void setOperandValToReplace(Value /*P*/ Op) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getPostIncLoops - Return the set of loops for which the expression has
  /// been adjusted to use post-inc mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::getPostIncLoops">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 68,
   FQN="llvm::IVStrideUse::getPostIncLoops", NM="_ZNK4llvm11IVStrideUse15getPostIncLoopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZNK4llvm11IVStrideUse15getPostIncLoopsEv")
  //</editor-fold>
  public /*const*/SmallPtrSet</*const*/ Loop /*P*/ > /*&*/ getPostIncLoops() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// transformToPostInc - Transform the expression to post-inc form for the
  /// given loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::transformToPostInc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 383,
   FQN="llvm::IVStrideUse::transformToPostInc", NM="_ZN4llvm11IVStrideUse18transformToPostIncEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUse18transformToPostIncEPKNS_4LoopE")
  //</editor-fold>
  public void transformToPostInc(/*const*/ Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Parent - a pointer to the IVUsers that owns this IVStrideUse.
  private IVUsers /*P*/ Parent;
  
  /// OperandValToReplace - The Value of the operand in the user instruction
  /// that this IVStrideUse is representing.
  private WeakVH OperandValToReplace;
  
  /// PostIncLoops - The set of loops for which Expr has been adjusted to
  /// use post-inc mode. This corresponds with SCEVExpander's post-inc concept.
  private SmallPtrSet</*const*/ Loop /*P*/ > PostIncLoops;
  
  /// Deleted - Implementation of CallbackVH virtual function to
  /// receive notification when the User is deleted.
  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::deleted">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 387,
   FQN="llvm::IVStrideUse::deleted", NM="_ZN4llvm11IVStrideUse7deletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUse7deletedEv")
  //</editor-fold>
  @Override public/*private*/ void deleted()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::~IVStrideUse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 37,
   FQN="llvm::IVStrideUse::~IVStrideUse", NM="_ZN4llvm11IVStrideUseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUseD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IVStrideUse::IVStrideUse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IVUsers.h", line = 37,
   FQN="llvm::IVStrideUse::IVStrideUse", NM="_ZN4llvm11IVStrideUseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm11IVStrideUseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ IVStrideUse(final /*const*/ IVStrideUse /*&*/ $Prm0) {
    // : CallbackVH(), ilist_node<IVStrideUse>(), Parent(.Parent), OperandValToReplace(.OperandValToReplace), PostIncLoops(.PostIncLoops) 
    super($Prm0);
    this.ilist_node$Flds = $ilist_node($Prm0);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  @Override public String toString() {
    return "" + "Parent=" + Parent // NOI18N
              + ", OperandValToReplace=" + OperandValToReplace // NOI18N
              + ", PostIncLoops=" + PostIncLoops // NOI18N
              + super.toString(); // NOI18N
  }
}
