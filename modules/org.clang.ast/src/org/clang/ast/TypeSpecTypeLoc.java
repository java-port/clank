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
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;


/// \brief A reasonable base class for TypeLocs that correspond to
/// types that are written as a type-specifier.
//<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 485,
 FQN="clang::TypeSpecTypeLoc", NM="_ZN5clang15TypeSpecTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLocE")
//</editor-fold>
public class TypeSpecTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<TypeSpecTypeLoc, Type, TypeSpecLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 490,
   FQN="clang::TypeSpecTypeLoc::(anonymous)", NM="_ZN5clang15TypeSpecTypeLocE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLocE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.ComparableLower {
    LocalDataSize($sizeof_TypeSpecLocInfo()),
    LocalDataAlignment(AlignOf.<TypeSpecLocInfo>Unnamed_enum.Alignment$Java);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::getNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 493,
   FQN="clang::TypeSpecTypeLoc::getNameLoc", NM="_ZNK5clang15TypeSpecTypeLoc10getNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15TypeSpecTypeLoc10getNameLocEv")
  //</editor-fold>
  public SourceLocation getNameLoc() /*const*/ {
    return new SourceLocation(this.getLocalData().NameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::setNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 496,
   FQN="clang::TypeSpecTypeLoc::setNameLoc", NM="_ZN5clang15TypeSpecTypeLoc10setNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLoc10setNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setNameLoc(SourceLocation Loc) {
    this.getLocalData().NameLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 499,
   FQN="clang::TypeSpecTypeLoc::getLocalSourceRange", NM="_ZNK5clang15TypeSpecTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15TypeSpecTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getNameLoc(), getNameLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 502,
   FQN="clang::TypeSpecTypeLoc::initializeLocal", NM="_ZN5clang15TypeSpecTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {
    setNameLoc(/*NO_COPY*/Loc);
  }
  
/*private:*/
  /*friend  class TypeLoc*/
  
  /// \brief Determines if the given type loc corresponds to a
  /// TypeSpecTypeLoc.  Since there is not actually a TypeSpecType in
  /// the type hierarchy, this is made somewhat complicated.
  ///
  /// There are a lot of types that currently use TypeSpecTypeLoc
  /// because it's a convenient base class.  Ideally we would not accept
  /// those here, but ideally we would have better implementations for
  /// them.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 272,
   FQN="clang::TypeSpecTypeLoc::isKind", NM="_ZN5clang15TypeSpecTypeLoc6isKindERKNS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLoc6isKindERKNS_7TypeLocE")
  //</editor-fold>
  /*friend*//*private*/ static boolean isKind(final /*const*/ TypeLoc /*&*/ TL) {
    if (TL.getType().hasLocalQualifiers()) {
      return false;
    }
    return new TSTChecker().Visit(new TypeLoc(TL));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::TypeSpecTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 485,
   FQN="clang::TypeSpecTypeLoc::TypeSpecTypeLoc", NM="_ZN5clang15TypeSpecTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ TypeSpecTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, TypeSpecTypeLoc, Type, TypeSpecLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::TypeSpecTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 485,
   FQN="clang::TypeSpecTypeLoc::TypeSpecTypeLoc", NM="_ZN5clang15TypeSpecTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TypeSpecTypeLoc(final /*const*/ TypeSpecTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, TypeSpecTypeLoc, Type, TypeSpecLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeSpecTypeLoc::TypeSpecTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 485,
   FQN="clang::TypeSpecTypeLoc::TypeSpecTypeLoc", NM="_ZN5clang15TypeSpecTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15TypeSpecTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ TypeSpecTypeLoc(JD$Move _dparam, final TypeSpecTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, TypeSpecTypeLoc, Type, TypeSpecLocInfo>(static_cast<TypeSpecTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final TypeSpecLocInfo createJavaEmptyLocalTypeLocInfo() { return new TypeSpecLocInfo(); }
  
  protected static int $sizeof_TypeSpecLocInfo() { return 1; }
  
  @Override protected Class<? extends Type> getTypeClass() { return Type.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
