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
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;


/// \brief Type source information for an attributed type.
//<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 724,
 FQN="clang::AttributedTypeLoc", NM="_ZN5clang17AttributedTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLocE")
//</editor-fold>
public class AttributedTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<AttributedTypeLoc, AttributedType, AttributedLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getAttrKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 729,
   FQN="clang::AttributedTypeLoc::getAttrKind", NM="_ZNK5clang17AttributedTypeLoc11getAttrKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc11getAttrKindEv")
  //</editor-fold>
  public AttributedType.Kind getAttrKind() /*const*/ {
    return getTypePtr().getAttrKind();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::hasAttrExprOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 733,
   FQN="clang::AttributedTypeLoc::hasAttrExprOperand", NM="_ZNK5clang17AttributedTypeLoc18hasAttrExprOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc18hasAttrExprOperandEv")
  //</editor-fold>
  public boolean hasAttrExprOperand() /*const*/ {
    return (getAttrKind().getValue() >= AttributedType.Kind.FirstExprOperandKind.getValue()
       && getAttrKind().getValue() <= AttributedType.Kind.LastExprOperandKind.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::hasAttrEnumOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 738,
   FQN="clang::AttributedTypeLoc::hasAttrEnumOperand", NM="_ZNK5clang17AttributedTypeLoc18hasAttrEnumOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc18hasAttrEnumOperandEv")
  //</editor-fold>
  public boolean hasAttrEnumOperand() /*const*/ {
    return (getAttrKind().getValue() >= AttributedType.Kind.FirstEnumOperandKind.getValue()
       && getAttrKind().getValue() <= AttributedType.Kind.LastEnumOperandKind.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::hasAttrOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 743,
   FQN="clang::AttributedTypeLoc::hasAttrOperand", NM="_ZNK5clang17AttributedTypeLoc14hasAttrOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc14hasAttrOperandEv")
  //</editor-fold>
  public boolean hasAttrOperand() /*const*/ {
    return hasAttrExprOperand() || hasAttrEnumOperand();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::isQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 747,
   FQN="clang::AttributedTypeLoc::isQualifier", NM="_ZNK5clang17AttributedTypeLoc11isQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc11isQualifierEv")
  //</editor-fold>
  public boolean isQualifier() /*const*/ {
    return getTypePtr().isQualifier();
  }

  
  /// The modified type, which is generally canonically different from
  /// the attribute type.
  ///    int main(int, char**) __attribute__((noreturn))
  ///    ~~~     ~~~~~~~~~~~~~
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getModifiedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 755,
   FQN="clang::AttributedTypeLoc::getModifiedLoc", NM="_ZNK5clang17AttributedTypeLoc14getModifiedLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc14getModifiedLocEv")
  //</editor-fold>
  public TypeLoc getModifiedLoc() /*const*/ {
    return getInnerTypeLoc();
  }

  
  /// The location of the attribute name, i.e.
  ///    __attribute__((regparm(1000)))
  ///                   ^~~~~~~
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getAttrNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 762,
   FQN="clang::AttributedTypeLoc::getAttrNameLoc", NM="_ZNK5clang17AttributedTypeLoc14getAttrNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc14getAttrNameLocEv")
  //</editor-fold>
  public SourceLocation getAttrNameLoc() /*const*/ {
    return new SourceLocation(getLocalData().AttrLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::setAttrNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 765,
   FQN="clang::AttributedTypeLoc::setAttrNameLoc", NM="_ZN5clang17AttributedTypeLoc14setAttrNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLoc14setAttrNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAttrNameLoc(SourceLocation loc) {
    getLocalData().AttrLoc.$assign(loc);
  }

  
  /// The attribute's expression operand, if it has one.
  ///    void *cur_thread __attribute__((address_space(21)))
  ///                                                  ^~
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getAttrExprOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 772,
   FQN="clang::AttributedTypeLoc::getAttrExprOperand", NM="_ZNK5clang17AttributedTypeLoc18getAttrExprOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc18getAttrExprOperandEv")
  //</editor-fold>
  public Expr /*P*/ getAttrExprOperand() /*const*/ {
    assert (hasAttrExprOperand());
    return getLocalData().Unnamed_field.ExprOperand;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::setAttrExprOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 776,
   FQN="clang::AttributedTypeLoc::setAttrExprOperand", NM="_ZN5clang17AttributedTypeLoc18setAttrExprOperandEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLoc18setAttrExprOperandEPNS_4ExprE")
  //</editor-fold>
  public void setAttrExprOperand(Expr /*P*/ e) {
    assert (hasAttrExprOperand());
    getLocalData().Unnamed_field.ExprOperand = e;
  }

  
  /// The location of the attribute's enumerated operand, if it has one.
  ///    void * __attribute__((objc_gc(weak)))
  ///                                  ^~~~
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getAttrEnumOperandLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 784,
   FQN="clang::AttributedTypeLoc::getAttrEnumOperandLoc", NM="_ZNK5clang17AttributedTypeLoc21getAttrEnumOperandLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc21getAttrEnumOperandLocEv")
  //</editor-fold>
  public SourceLocation getAttrEnumOperandLoc() /*const*/ {
    assert (hasAttrEnumOperand());
    return SourceLocation.getFromRawEncoding(getLocalData().Unnamed_field.EnumOperandLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::setAttrEnumOperandLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 788,
   FQN="clang::AttributedTypeLoc::setAttrEnumOperandLoc", NM="_ZN5clang17AttributedTypeLoc21setAttrEnumOperandLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLoc21setAttrEnumOperandLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAttrEnumOperandLoc(SourceLocation loc) {
    assert (hasAttrEnumOperand());
    getLocalData().Unnamed_field.EnumOperandLoc = loc.getRawEncoding();
  }

  
  /// The location of the parentheses around the operand, if there is
  /// an operand.
  ///    void * __attribute__((objc_gc(weak)))
  ///                                 ^    ^
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getAttrOperandParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 797,
   FQN="clang::AttributedTypeLoc::getAttrOperandParensRange", NM="_ZNK5clang17AttributedTypeLoc25getAttrOperandParensRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc25getAttrOperandParensRangeEv")
  //</editor-fold>
  public SourceRange getAttrOperandParensRange() /*const*/ {
    assert (hasAttrOperand());
    return new SourceRange(getLocalData().OperandParens);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::setAttrOperandParensRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 801,
   FQN="clang::AttributedTypeLoc::setAttrOperandParensRange", NM="_ZN5clang17AttributedTypeLoc25setAttrOperandParensRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLoc25setAttrOperandParensRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setAttrOperandParensRange(SourceRange range) {
    assert (hasAttrOperand());
    getLocalData().OperandParens.$assign(range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 806,
   FQN="clang::AttributedTypeLoc::getLocalSourceRange", NM="_ZNK5clang17AttributedTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    // Note that this does *not* include the range of the attribute
    // enclosure, e.g.:
    //    __attribute__((foo(bar)))
    //    ^~~~~~~~~~~~~~~        ~~
    // or
    //    [[foo(bar)]]
    //    ^~        ~~
    // That enclosure doesn't necessarily belong to a single attribute
    // anyway.
    SourceRange range/*J*/= new SourceRange(getAttrNameLoc());
    if (hasAttrOperand()) {
      range.setEnd(getAttrOperandParensRange().getEnd());
    }
    return range;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 822,
   FQN="clang::AttributedTypeLoc::initializeLocal", NM="_ZN5clang17AttributedTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, SourceLocation loc) {
    setAttrNameLoc(/*NO_COPY*/loc);
    if (hasAttrExprOperand()) {
      setAttrOperandParensRange(new SourceRange(/*NO_COPY*/loc));
      setAttrExprOperand((Expr /*P*/ )null);
    } else if (hasAttrEnumOperand()) {
      setAttrOperandParensRange(new SourceRange(/*NO_COPY*/loc));
      setAttrEnumOperandLoc(/*NO_COPY*/loc);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 833,
   FQN="clang::AttributedTypeLoc::getInnerType", NM="_ZNK5clang17AttributedTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang17AttributedTypeLoc12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return getTypePtr().getModifiedType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::AttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 724,
   FQN="clang::AttributedTypeLoc::AttributedTypeLoc", NM="_ZN5clang17AttributedTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ AttributedTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, AttributedTypeLoc, AttributedType, AttributedLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::AttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 724,
   FQN="clang::AttributedTypeLoc::AttributedTypeLoc", NM="_ZN5clang17AttributedTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ AttributedTypeLoc(final /*const*/ AttributedTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, AttributedTypeLoc, AttributedType, AttributedLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AttributedTypeLoc::AttributedTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 724,
   FQN="clang::AttributedTypeLoc::AttributedTypeLoc", NM="_ZN5clang17AttributedTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang17AttributedTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ AttributedTypeLoc(JD$Move _dparam, final AttributedTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, AttributedTypeLoc, AttributedType, AttributedLocInfo>(static_cast<AttributedTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final AttributedLocInfo createJavaEmptyLocalTypeLocInfo() { return new AttributedLocInfo(); }
  
  @Override protected Class<AttributedType> getTypeClass() { return AttributedType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
