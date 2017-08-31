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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// FunctionCodeRegion - A region that represents code texts of function.
//<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 541,
 FQN="clang::ento::FunctionCodeRegion", NM="_ZN5clang4ento18FunctionCodeRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento18FunctionCodeRegionE")
//</editor-fold>
public class FunctionCodeRegion extends /*public*/ CodeTextRegion implements Destructors.ClassWithDestructor {
  private /*const*/ NamedDecl /*P*/ FD;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::FunctionCodeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 544,
   FQN="clang::ento::FunctionCodeRegion::FunctionCodeRegion", NM="_ZN5clang4ento18FunctionCodeRegionC1EPKNS_9NamedDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento18FunctionCodeRegionC1EPKNS_9NamedDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  public FunctionCodeRegion(/*const*/ NamedDecl /*P*/ fd, /*const*/ MemRegion /*P*/ sreg) {
    // : CodeTextRegion(sreg, FunctionCodeRegionKind), FD(fd) 
    //START JInit
    super(sreg, Kind.FunctionCodeRegionKind);
    this.FD = fd;
    //END JInit
    assert (isa_ObjCMethodDecl(fd) || isa_FunctionDecl(fd));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::getLocationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 549,
   FQN="clang::ento::FunctionCodeRegion::getLocationType", NM="_ZNK5clang4ento18FunctionCodeRegion15getLocationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento18FunctionCodeRegion15getLocationTypeEv")
  //</editor-fold>
  @Override public QualType getLocationType() /*const*//* override*/ {
    final /*const*/ ASTContext /*&*/ Ctx = getContext();
    {
      /*const*/ FunctionDecl /*P*/ D = dyn_cast_FunctionDecl(FD);
      if ((D != null)) {
        return Ctx.getPointerType(D.getType());
      }
    }
    assert (isa_ObjCMethodDecl(FD));
    assert (false) : "Getting the type of ObjCMethod is not supported yet";
    
    // TODO: We might want to return a different type here (ex: id (*ty)(...))
    //       depending on how it is used.
    return new QualType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 563,
   FQN="clang::ento::FunctionCodeRegion::getDecl", NM="_ZNK5clang4ento18FunctionCodeRegion7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento18FunctionCodeRegion7getDeclEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getDecl() /*const*/ {
    return FD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 456,
   FQN="clang::ento::FunctionCodeRegion::dumpToStream", NM="_ZNK5clang4ento18FunctionCodeRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento18FunctionCodeRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    os.$out(/*KEEP_STR*/"code{").$out(getDecl().getDeclName().getAsString()).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 363,
   FQN="clang::ento::FunctionCodeRegion::Profile", NM="_ZNK5clang4ento18FunctionCodeRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento18FunctionCodeRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    FunctionCodeRegion.ProfileRegion(ID, FD, superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 356,
   FQN="clang::ento::FunctionCodeRegion::ProfileRegion", NM="_ZN5clang4ento18FunctionCodeRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_9NamedDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento18FunctionCodeRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_9NamedDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  public static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ NamedDecl /*P*/ FD, 
               /*const*/ MemRegion /*P*/ $Prm2) {
    ID.AddInteger_int(MemRegion.Kind.FunctionCodeRegionKind.getValue());
    ID.AddPointer(FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 574,
   FQN="clang::ento::FunctionCodeRegion::classof", NM="_ZN5clang4ento18FunctionCodeRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento18FunctionCodeRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.FunctionCodeRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::FunctionCodeRegion::~FunctionCodeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 541,
   FQN="clang::ento::FunctionCodeRegion::~FunctionCodeRegion", NM="_ZN5clang4ento18FunctionCodeRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento18FunctionCodeRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "FD=" + FD // NOI18N
              + super.toString(); // NOI18N
  }
}
