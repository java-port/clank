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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


/// Common features for diagnostics with an associated DebugLoc
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 341,
 FQN="llvm::DiagnosticInfoWithDebugLocBase", NM="_ZN4llvm30DiagnosticInfoWithDebugLocBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30DiagnosticInfoWithDebugLocBaseE")
//</editor-fold>
public abstract class DiagnosticInfoWithDebugLocBase extends /*public*/ DiagnosticInfo implements Destructors.ClassWithDestructor {
/*public:*/
  /// \p Fn is the function where the diagnostic is being emitted. \p DLoc is
  /// the location information to use in the diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase::DiagnosticInfoWithDebugLocBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 345,
   FQN="llvm::DiagnosticInfoWithDebugLocBase::DiagnosticInfoWithDebugLocBase", NM="_ZN4llvm30DiagnosticInfoWithDebugLocBaseC1ENS_14DiagnosticKindENS_18DiagnosticSeverityERKNS_8FunctionERKNS_8DebugLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30DiagnosticInfoWithDebugLocBaseC1ENS_14DiagnosticKindENS_18DiagnosticSeverityERKNS_8FunctionERKNS_8DebugLocE")
  //</editor-fold>
  public DiagnosticInfoWithDebugLocBase( DiagnosticKind Kind,
       DiagnosticSeverity Severity,
      final /*const*/ Function /*&*/ Fn,
      final /*const*/ DebugLoc /*&*/ DLoc) {
    // : DiagnosticInfo(Kind, Severity), Fn(Fn), DLoc(DLoc)
    //START JInit
    super(Kind.getValue(), Severity);
    this./*&*/Fn=/*&*/Fn;
    this.DLoc = new DebugLoc(DLoc);
    //END JInit
  }


  /// Return true if location information is available for this diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase::isLocationAvailable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 150,
   FQN="llvm::DiagnosticInfoWithDebugLocBase::isLocationAvailable", NM="_ZNK4llvm30DiagnosticInfoWithDebugLocBase19isLocationAvailableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoWithDebugLocBase19isLocationAvailableEv")
  //</editor-fold>
  public boolean isLocationAvailable() /*const*/ {
    return ((getDebugLoc().$DILocation$P()) != null);
  }


  /// Return a string with the location information for this diagnostic
  /// in the format "file:line:col". If location information is not available,
  /// it returns "<unknown>:0:0".
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase::getLocationStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 164,
   FQN="llvm::DiagnosticInfoWithDebugLocBase::getLocationStr", NM="_ZNK4llvm30DiagnosticInfoWithDebugLocBase14getLocationStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoWithDebugLocBase14getLocationStrEv")
  //</editor-fold>
  public /*const*/std.string getLocationStr() /*const*/ {
    StringRef Filename/*J*/= new StringRef(/*KEEP_STR*/"<unknown>");
    uint$ptr Line = create_uint$ptr(0);
    uint$ptr Column = create_uint$ptr(0);
    if (isLocationAvailable()) {
      getLocation($AddrOf(Filename), $AddrOf(Line), $AddrOf(Column));
    }
    return ($add_Twine$C($add_Twine$C($add_Twine$C($add_StringRef$C_char$ptr$C(Filename, /*KEEP_STR*/$COLON), new Twine(JD$UInt.INSTANCE, Line.$star())), new Twine(/*KEEP_STR*/$COLON)), new Twine(JD$UInt.INSTANCE, Column.$star()))).str();
  }


  /// Return location information for this diagnostic in three parts:
  /// the source file name, line number and column.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 154,
   FQN="llvm::DiagnosticInfoWithDebugLocBase::getLocation", NM="_ZNK4llvm30DiagnosticInfoWithDebugLocBase11getLocationEPNS_9StringRefEPjS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoWithDebugLocBase11getLocationEPNS_9StringRefEPjS3_")
  //</editor-fold>
  public void getLocation(StringRef /*P*/ Filename,
             uint$ptr/*uint P*/ Line,
             uint$ptr/*uint P*/ Column) /*const*/ {
    DILocation /*P*/ L = getDebugLoc().$DILocation$P();
    assert (L != null) : "debug location is invalid";
    $Deref(Filename).$assignMove(L.getFilename());
    Line.$set(L.getLine());
    Column.$set(L.getColumn());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase::getFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 363,
   FQN="llvm::DiagnosticInfoWithDebugLocBase::getFunction", NM="_ZNK4llvm30DiagnosticInfoWithDebugLocBase11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoWithDebugLocBase11getFunctionEv")
  //</editor-fold>
  public /*const*/ Function /*&*/ getFunction() /*const*/ {
    return Fn;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase::getDebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 364,
   FQN="llvm::DiagnosticInfoWithDebugLocBase::getDebugLoc", NM="_ZNK4llvm30DiagnosticInfoWithDebugLocBase11getDebugLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm30DiagnosticInfoWithDebugLocBase11getDebugLocEv")
  //</editor-fold>
  public /*const*/ DebugLoc /*&*/ getDebugLoc() /*const*/ {
    return DLoc;
  }

/*private:*/
  /// Function where this diagnostic is triggered.
  private final /*const*/ Function /*&*/ Fn;

  /// Debug location where this diagnostic is triggered.
  private DebugLoc DLoc;
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoWithDebugLocBase::~DiagnosticInfoWithDebugLocBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 341,
   FQN="llvm::DiagnosticInfoWithDebugLocBase::~DiagnosticInfoWithDebugLocBase", NM="_ZN4llvm30DiagnosticInfoWithDebugLocBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm30DiagnosticInfoWithDebugLocBaseD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DLoc.$destroy();
    super.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "Fn=" + Fn // NOI18N
              + ", DLoc=" + DLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
