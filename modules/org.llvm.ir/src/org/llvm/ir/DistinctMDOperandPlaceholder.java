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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// Placeholder metadata for operands of distinct MDNodes.
///
/// This is a lightweight placeholder for an operand of a distinct node.  It's
/// purpose is to help track forward references when creating a distinct node.
/// This allows distinct nodes involved in a cycle to be constructed before
/// their operands without requiring a heavyweight temporary node with
/// full-blown RAUW support.
///
/// Each placeholder supports only a single MDNode user.  Clients should pass
/// an ID, retrieved via \a getID(), to indicate the "real" operand that this
/// should be replaced with.
///
/// While it would be possible to implement move operators, they would be
/// fairly expensive.  Leave them unimplemented to discourage their use
/// (clients can use std::deque, std::list, BumpPtrAllocator, etc.).
//<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1211,
 FQN="llvm::DistinctMDOperandPlaceholder", NM="_ZN4llvm28DistinctMDOperandPlaceholderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm28DistinctMDOperandPlaceholderE")
//</editor-fold>
public class DistinctMDOperandPlaceholder extends /*public*/ Metadata implements Destructors.ClassWithDestructor {
  /*friend  class MetadataTracking*/

  /*friend*/public/*private*/ type$ptr<Metadata /*P*/ /*P*/> Use/* = null*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1216,
   FQN="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder", NM="_ZN4llvm28DistinctMDOperandPlaceholderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm28DistinctMDOperandPlaceholderC1Ev")
  //</editor-fold>
  protected/*private*/ DistinctMDOperandPlaceholder() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1217,
   FQN="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder", NM="_ZN4llvm28DistinctMDOperandPlaceholderC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm28DistinctMDOperandPlaceholderC1EOS0_")
  //</editor-fold>
  protected/*private*/ DistinctMDOperandPlaceholder(JD$Move _dparam, final DistinctMDOperandPlaceholder /*&&*/$Prm0) {  super(_dparam, $Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1218,
   FQN="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder", NM="_ZN4llvm28DistinctMDOperandPlaceholderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm28DistinctMDOperandPlaceholderC1ERKS0_")
  //</editor-fold>
  protected/*private*/ DistinctMDOperandPlaceholder(final /*const*/ DistinctMDOperandPlaceholder /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1221,
   FQN="llvm::DistinctMDOperandPlaceholder::DistinctMDOperandPlaceholder", NM="_ZN4llvm28DistinctMDOperandPlaceholderC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm28DistinctMDOperandPlaceholderC1Ej")
  //</editor-fold>
  public /*explicit*/ DistinctMDOperandPlaceholder(/*uint*/int ID) {
    // : Metadata(DistinctMDOperandPlaceholderKind, Distinct), Use(null)
    //START JInit
    super(MetadataKind.DistinctMDOperandPlaceholderKind.getValue(), StorageType.Distinct);
    /*InClass*/this.Use = null;
    //END JInit
    SubclassData32 = ID;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder::~DistinctMDOperandPlaceholder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1226,
   FQN="llvm::DistinctMDOperandPlaceholder::~DistinctMDOperandPlaceholder", NM="_ZN4llvm28DistinctMDOperandPlaceholderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm28DistinctMDOperandPlaceholderD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((Use != null)) {
      Use.$set(null);
    }
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder::getID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1231,
   FQN="llvm::DistinctMDOperandPlaceholder::getID", NM="_ZNK4llvm28DistinctMDOperandPlaceholder5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm28DistinctMDOperandPlaceholder5getIDEv")
  //</editor-fold>
  public /*uint*/int getID() /*const*/ {
    return SubclassData32;
  }


  /// Replace the use of this with MD.
  //<editor-fold defaultstate="collapsed" desc="llvm::DistinctMDOperandPlaceholder::replaceUseWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1234,
   FQN="llvm::DistinctMDOperandPlaceholder::replaceUseWith", NM="_ZN4llvm28DistinctMDOperandPlaceholder14replaceUseWithEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm28DistinctMDOperandPlaceholder14replaceUseWithEPNS_8MetadataE")
  //</editor-fold>
  public void replaceUseWith(Metadata /*P*/ MD) {
    if (!(Use != null)) {
      return;
    }
    Use.$set(MD);
    Use = null;
  }


  @Override public String toString() {
    return "" + "Use=" + Use // NOI18N
              + super.toString(); // NOI18N
  }
}
