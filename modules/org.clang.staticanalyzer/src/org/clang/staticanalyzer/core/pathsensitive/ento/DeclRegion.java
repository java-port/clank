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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clank.java.std;
import org.llvm.support.raw_string_ostream;

//<editor-fold defaultstate="collapsed" desc="clang::ento::DeclRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 838,
 FQN="clang::ento::DeclRegion", NM="_ZN5clang4ento10DeclRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento10DeclRegionE")
//</editor-fold>
public abstract class DeclRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
/*protected:*/
  protected /*const*/ Decl /*P*/ D;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DeclRegion::DeclRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 842,
   FQN="clang::ento::DeclRegion::DeclRegion", NM="_ZN5clang4ento10DeclRegionC1EPKNS_4DeclEPKNS0_9MemRegionENS5_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento10DeclRegionC1EPKNS_4DeclEPKNS0_9MemRegionENS5_4KindE")
  //</editor-fold>
  protected DeclRegion(/*const*/ Decl /*P*/ d, /*const*/ MemRegion /*P*/ sReg, MemRegion.Kind k) {
    // : TypedValueRegion(sReg, k), D(d) 
    //START JInit
    super(sReg, k);
    this.D = d;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DeclRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 317,
   FQN="clang::ento::DeclRegion::ProfileRegion", NM="_ZN5clang4ento10DeclRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_4DeclEPKNS0_9MemRegionENS8_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento10DeclRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_4DeclEPKNS0_9MemRegionENS8_4KindE")
  //</editor-fold>
  protected static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, /*const*/ Decl /*P*/ D, 
               /*const*/ MemRegion /*P*/ superRegion, MemRegion.Kind k) {
    ID.AddInteger_uint(((/*static_cast*//*uint*/int)(k.getValue())));
    ID.AddPointer(D);
    ID.AddPointer(superRegion);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DeclRegion::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 849,
   FQN="clang::ento::DeclRegion::getDecl", NM="_ZNK5clang4ento10DeclRegion7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento10DeclRegion7getDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDecl() /*const*/ {
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DeclRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 324,
   FQN="clang::ento::DeclRegion::Profile", NM="_ZNK5clang4ento10DeclRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento10DeclRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    DeclRegion.ProfileRegion(ID, D, superRegion, getKind());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DeclRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 852,
   FQN="clang::ento::DeclRegion::classof", NM="_ZN5clang4ento10DeclRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento10DeclRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    /*uint*/int k = R.getKind().getValue();
    return $greatereq_uint(k, Kind.BEGIN_DECL_REGIONS.getValue()) && $lesseq_uint(k, Kind.END_DECL_REGIONS.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DeclRegion::~DeclRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 838,
   FQN="clang::ento::DeclRegion::~DeclRegion", NM="_ZN5clang4ento10DeclRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento10DeclRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    std.string Buf = new std.string();
    if (D != null) {
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      D.print(OS);
      OS.flush();      
      return Buf.toJavaString();
    } else {
      Buf.$addassign("<null>");
    }
    return "" + "Decl=[" + Buf.toJavaString() + "]" // NOI18N
              + super.toString(); // NOI18N
  }
}
