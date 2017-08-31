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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// \brief Wrapper of type source information for a type with
/// non-trivial direct qualifiers.
///
/// Currently, we intentionally do not provide source location for
/// type qualifiers.
//<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 247,
 FQN="clang::QualifiedTypeLoc", NM="_ZN5clang16QualifiedTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang16QualifiedTypeLocE")
//</editor-fold>
public final class QualifiedTypeLoc extends /*public*/ TypeLoc {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 249,
   FQN="clang::QualifiedTypeLoc::getLocalSourceRange", NM="_ZNK5clang16QualifiedTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang16QualifiedTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::getUnqualifiedLoc">
  @Converted(kind = Converted.Kind.MANUAL/*java asserts*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 253,
   FQN="clang::QualifiedTypeLoc::getUnqualifiedLoc", NM="_ZNK5clang16QualifiedTypeLoc17getUnqualifiedLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang16QualifiedTypeLoc17getUnqualifiedLocEv")
  //</editor-fold>
  public UnqualTypeLoc getUnqualifiedLoc() /*const*/ {
    type$ptr p = null;
    if (Data != null) {
      /*uint*/int align = TypeLoc.getLocalAlignmentForType(new QualType(getTypePtr(), 0));
      assert align == 1 : "In Java we expect alignment to be 1 vs. " + align;
      int dataInt = Data.$index(); // $ulong2uintptr_t(llvm.alignTo($uintptr_t2ulong(dataInt), $uint2ulong(align)));
      int alignedInt = (int) llvm.alignTo(dataInt, align);
      assert (alignedInt == dataInt) : "in Java we expect no realignment";
      p = Data.$add(alignedInt - dataInt);
    }
    return new UnqualTypeLoc(getTypePtr(), p);
  }

  
  /// Initializes the local data of this type source info block to
  /// provide no information.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 263,
   FQN="clang::QualifiedTypeLoc::initializeLocal", NM="_ZN5clang16QualifiedTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang16QualifiedTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    // do nothing
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::copyLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 267,
   FQN="clang::QualifiedTypeLoc::copyLocal", NM="_ZN5clang16QualifiedTypeLoc9copyLocalENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang16QualifiedTypeLoc9copyLocalENS_7TypeLocE")
  //</editor-fold>
  public void copyLocal(TypeLoc other) {
    // do nothing
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 271,
   FQN="clang::QualifiedTypeLoc::getNextTypeLoc", NM="_ZNK5clang16QualifiedTypeLoc14getNextTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang16QualifiedTypeLoc14getNextTypeLocEv")
  //</editor-fold>
  public TypeLoc getNextTypeLoc() /*const*/ {
    return new TypeLoc(JD$Move.INSTANCE, getUnqualifiedLoc());
  }

  
  /// \brief Returns the size of the type source info data block that is
  /// specific to this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::getLocalDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 277,
   FQN="clang::QualifiedTypeLoc::getLocalDataSize", NM="_ZNK5clang16QualifiedTypeLoc16getLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang16QualifiedTypeLoc16getLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getLocalDataSize() /*const*/ {
    // In fact, we don't currently preserve any location information
    // for qualifiers.
    return 0;
  }

  
  /// \brief Returns the alignment of the type source info data block that is
  /// specific to this type.
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::getLocalDataAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 285,
   FQN="clang::QualifiedTypeLoc::getLocalDataAlignment", NM="_ZNK5clang16QualifiedTypeLoc21getLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang16QualifiedTypeLoc21getLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getLocalDataAlignment() /*const*/ {
    // We don't preserve any location information.
    return 1;
  }

/*private:*/
  /*friend  class TypeLoc*/
  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 292,
   FQN="clang::QualifiedTypeLoc::isKind", NM="_ZN5clang16QualifiedTypeLoc6isKindERKNS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang16QualifiedTypeLoc6isKindERKNS_7TypeLocE")
  //</editor-fold>
  /*friend*//*private*/ static boolean isKind(final /*const*/ TypeLoc /*&*/ TL) {
    return TL.getType().hasLocalQualifiers();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::QualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 247,
   FQN="clang::QualifiedTypeLoc::QualifiedTypeLoc", NM="_ZN5clang16QualifiedTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang16QualifiedTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ QualifiedTypeLoc() {
    // : TypeLoc() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::QualifiedTypeLoc::QualifiedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 247,
   FQN="clang::QualifiedTypeLoc::QualifiedTypeLoc", NM="_ZN5clang16QualifiedTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang16QualifiedTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ QualifiedTypeLoc(JD$Move _dparam, final QualifiedTypeLoc /*&&*/$Prm0) {
    // : TypeLoc(static_cast<QualifiedTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final int javaAllocateLocalData() { /*no LocInfo data*/return 0; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
