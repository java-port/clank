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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.clang.basic.*;

/// \brief Represents the parsed form of a C++ template argument.
//<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 30,
 FQN="clang::ParsedTemplateArgument", NM="_ZN5clang22ParsedTemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang22ParsedTemplateArgumentE")
//</editor-fold>
public class ParsedTemplateArgument implements NativePOD<ParsedTemplateArgument>, Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Describes the kind of template argument that was parsed.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::KindType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 33,
   FQN="clang::ParsedTemplateArgument::KindType", NM="_ZN5clang22ParsedTemplateArgument8KindTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang22ParsedTemplateArgument8KindTypeE")
  //</editor-fold>
  public enum KindType implements Native.ComparableLower {
    /// \brief A template type parameter, stored as a type.
    Type(0),
    /// \brief A non-type template parameter, stored as an expression.
    NonType(Type.getValue() + 1),
    /// \brief A template template argument, stored as a template name.
    Template(NonType.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static KindType valueOf(int val) {
      KindType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final KindType[] VALUES;
      private static final KindType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (KindType kind : KindType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new KindType[min < 0 ? (1-min) : 0];
        VALUES = new KindType[max >= 0 ? (1+max) : 0];
        for (KindType kind : KindType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private KindType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((KindType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((KindType)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Build an empty template argument. 
  ///
  /// This template argument is invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::ParsedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 45,
   FQN="clang::ParsedTemplateArgument::ParsedTemplateArgument", NM="_ZN5clang22ParsedTemplateArgumentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang22ParsedTemplateArgumentC1Ev")
  //</editor-fold>
  public ParsedTemplateArgument() {
    // : Kind(Type), Arg(null), SS(), Loc(), EllipsisLoc() 
    //START JInit
    this.Kind = KindType.Type;
    this.Arg = null;
    this.SS = new CXXScopeSpec();
    this.Loc = new SourceLocation();
    this.EllipsisLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Create a template type argument or non-type template argument.
  ///
  /// \param Arg the template type argument or non-type template argument.
  /// \param Loc the location of the type.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::ParsedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 51,
   FQN="clang::ParsedTemplateArgument::ParsedTemplateArgument", NM="_ZN5clang22ParsedTemplateArgumentC1ENS0_8KindTypeEPvNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang22ParsedTemplateArgumentC1ENS0_8KindTypeEPvNS_14SourceLocationE")
  //</editor-fold>
  public ParsedTemplateArgument(KindType Kind, Object/*void P*/ Arg, SourceLocation Loc) {
    // : Kind(Kind), Arg(Arg), SS(), Loc(Loc), EllipsisLoc() 
    //START JInit
    this.Kind = Kind;
    this.Arg = Arg;
    this.SS = new CXXScopeSpec();
    this.Loc = new SourceLocation(Loc);
    this.EllipsisLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Create a template template argument.
  ///
  /// \param SS the C++ scope specifier that precedes the template name, if
  /// any.
  ///
  /// \param Template the template to which this template template 
  /// argument refers.
  ///
  /// \param TemplateLoc the location of the template name.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::ParsedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 63,
   FQN="clang::ParsedTemplateArgument::ParsedTemplateArgument", NM="_ZN5clang22ParsedTemplateArgumentC1ERKNS_12CXXScopeSpecENS_9OpaquePtrINS_12TemplateNameEEENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang22ParsedTemplateArgumentC1ERKNS_12CXXScopeSpecENS_9OpaquePtrINS_12TemplateNameEEENS_14SourceLocationE")
  //</editor-fold>
  public ParsedTemplateArgument(final /*const*/ CXXScopeSpec /*&*/ SS, 
      OpaquePtr<TemplateName> Template, 
      SourceLocation TemplateLoc) {
    // : Kind(ParsedTemplateArgument::Template), Arg(Template.getAsOpaquePtr()), SS(SS), Loc(TemplateLoc), EllipsisLoc() 
    //START JInit
    this.Kind = ParsedTemplateArgument.KindType.Template;
    this.Arg = Template.getAsOpaquePtr();
    this.SS = new CXXScopeSpec(SS);
    this.Loc = new SourceLocation(TemplateLoc);
    this.EllipsisLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Determine whether the given template argument is invalid.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 71,
   FQN="clang::ParsedTemplateArgument::isInvalid", NM="_ZNK5clang22ParsedTemplateArgument9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return $eq_ptr(Arg, null);
  }

  
  /// \brief Determine what kind of template argument we have.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 74,
   FQN="clang::ParsedTemplateArgument::getKind", NM="_ZNK5clang22ParsedTemplateArgument7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument7getKindEv")
  //</editor-fold>
  public KindType getKind() /*const*/ {
    return Kind;
  }

  
  /// \brief Retrieve the template type argument's type.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getAsType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 77,
   FQN="clang::ParsedTemplateArgument::getAsType", NM="_ZNK5clang22ParsedTemplateArgument9getAsTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument9getAsTypeEv")
  //</editor-fold>
  public OpaquePtr<QualType> getAsType() /*const*/ {
    assert (Kind == KindType.Type) : "Not a template type argument";
    return OpaquePtr.<QualType>getFromOpaquePtr(Arg);
  }

  
  /// \brief Retrieve the non-type template argument's expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getAsExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 83,
   FQN="clang::ParsedTemplateArgument::getAsExpr", NM="_ZNK5clang22ParsedTemplateArgument9getAsExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument9getAsExprEv")
  //</editor-fold>
  public Expr /*P*/ getAsExpr() /*const*/ {
    assert (Kind == KindType.NonType) : "Not a non-type template argument";
    return ((/*static_cast*/Expr /*P*/ )(Arg));
  }

  
  /// \brief Retrieve the template template argument's template name.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getAsTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 89,
   FQN="clang::ParsedTemplateArgument::getAsTemplate", NM="_ZNK5clang22ParsedTemplateArgument13getAsTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument13getAsTemplateEv")
  //</editor-fold>
  public OpaquePtr<TemplateName> getAsTemplate() /*const*/ {
    assert (Kind == KindType.Template) : "Not a template template argument";
    return OpaquePtr.<TemplateName>getFromOpaquePtr(Arg);
  }

  
  /// \brief Retrieve the location of the template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 95,
   FQN="clang::ParsedTemplateArgument::getLocation", NM="_ZNK5clang22ParsedTemplateArgument11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  
  /// \brief Retrieve the nested-name-specifier that precedes the template
  /// name in a template template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getScopeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 99,
   FQN="clang::ParsedTemplateArgument::getScopeSpec", NM="_ZNK5clang22ParsedTemplateArgument12getScopeSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument12getScopeSpecEv")
  //</editor-fold>
  public /*const*/ CXXScopeSpec /*&*/ getScopeSpec() /*const*/ {
    assert (Kind == KindType.Template) : "Only template template arguments can have a scope specifier";
    return SS;
  }

  
  /// \brief Retrieve the location of the ellipsis that makes a template
  /// template argument into a pack expansion.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getEllipsisLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 107,
   FQN="clang::ParsedTemplateArgument::getEllipsisLoc", NM="_ZNK5clang22ParsedTemplateArgument14getEllipsisLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZNK5clang22ParsedTemplateArgument14getEllipsisLocEv")
  //</editor-fold>
  public SourceLocation getEllipsisLoc() /*const*/ {
    assert (Kind == KindType.Template) : "Only template template arguments can have an ellipsis";
    return new SourceLocation(EllipsisLoc);
  }

  
  /// \brief Retrieve a pack expansion of the given template template
  /// argument.
  ///
  /// \param EllipsisLoc The location of the ellipsis.
  
  /// \brief Retrieve a pack expansion of the given template template
  /// argument.
  ///
  /// \param EllipsisLoc The location of the ellipsis.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::getTemplatePackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 489,
   FQN="clang::ParsedTemplateArgument::getTemplatePackExpansion", NM="_ZNK5clang22ParsedTemplateArgument24getTemplatePackExpansionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang22ParsedTemplateArgument24getTemplatePackExpansionENS_14SourceLocationE")
  //</editor-fold>
  public ParsedTemplateArgument getTemplatePackExpansion(SourceLocation EllipsisLoc) /*const*/ {
    ParsedTemplateArgument Result = null;
    try {
      assert (Kind == KindType.Template) : "Only template template arguments can be pack expansions here";
      assert (getAsTemplate().getTemplateName().containsUnexpandedParameterPack()) : "Template template argument pack expansion without packs";
      Result/*J*/= new ParsedTemplateArgument(/*Deref*/this);
      Result.EllipsisLoc.$assign(EllipsisLoc);
      return new ParsedTemplateArgument(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }


/*private:*/
  private KindType Kind;
  
  /// \brief The actual template argument representation, which may be
  /// an \c Sema::TypeTy* (for a type), an Expr* (for an
  /// expression), or an Sema::TemplateTy (for a template).
  private Object/*void P*/ Arg;
  
  /// \brief The nested-name-specifier that can accompany a template template
  /// argument.
  private CXXScopeSpec SS;
  
  /// \brief the location of the template argument.
  private SourceLocation Loc;
  
  /// \brief The ellipsis location that can accompany a template template
  /// argument (turning it into a template template argument expansion).
  private SourceLocation EllipsisLoc;
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 30,
   FQN="clang::ParsedTemplateArgument::operator=", NM="_ZN5clang22ParsedTemplateArgumentaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang22ParsedTemplateArgumentaSERKS0_")
  //</editor-fold>
  public /*inline*/ ParsedTemplateArgument /*&*/ $assign(final /*const*/ ParsedTemplateArgument /*&*/ $Prm0) {
    this.Kind = $Prm0.Kind;
    this.Arg = $Prm0.Arg;
    this.SS.$assign($Prm0.SS);
    this.Loc.$assign($Prm0.Loc);
    this.EllipsisLoc.$assign($Prm0.EllipsisLoc);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::~ParsedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 30,
   FQN="clang::ParsedTemplateArgument::~ParsedTemplateArgument", NM="_ZN5clang22ParsedTemplateArgumentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang22ParsedTemplateArgumentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SS.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::ParsedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 30,
   FQN="clang::ParsedTemplateArgument::ParsedTemplateArgument", NM="_ZN5clang22ParsedTemplateArgumentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang22ParsedTemplateArgumentC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ParsedTemplateArgument(final /*const*/ ParsedTemplateArgument /*&*/ $Prm0) {
    // : Kind(.Kind), Arg(.Arg), SS(.SS), Loc(.Loc), EllipsisLoc(.EllipsisLoc) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Arg = $Prm0.Arg;
    this.SS = new CXXScopeSpec($Prm0.SS);
    this.Loc = new SourceLocation($Prm0.Loc);
    this.EllipsisLoc = new SourceLocation($Prm0.EllipsisLoc);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::ParsedTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 30,
   FQN="clang::ParsedTemplateArgument::ParsedTemplateArgument", NM="_ZN5clang22ParsedTemplateArgumentC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang22ParsedTemplateArgumentC1EOS0_")
  //</editor-fold>
  public /*inline*/ ParsedTemplateArgument(JD$Move _dparam, final ParsedTemplateArgument /*&&*/$Prm0) {
    // : Kind(static_cast<ParsedTemplateArgument &&>().Kind), Arg(static_cast<ParsedTemplateArgument &&>().Arg), SS(static_cast<ParsedTemplateArgument &&>().SS), Loc(static_cast<ParsedTemplateArgument &&>().Loc), EllipsisLoc(static_cast<ParsedTemplateArgument &&>().EllipsisLoc) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Arg = $Prm0.Arg;
    this.SS = new CXXScopeSpec(JD$Move.INSTANCE, $Prm0.SS);
    this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
    this.EllipsisLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EllipsisLoc);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ParsedTemplateArgument::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 30,
   FQN="clang::ParsedTemplateArgument::operator=", NM="_ZN5clang22ParsedTemplateArgumentaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang22ParsedTemplateArgumentaSEOS0_")
  //</editor-fold>
  public /*inline*/ ParsedTemplateArgument /*&*/ $assignMove(final ParsedTemplateArgument /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Arg = $Prm0.Arg;
    this.SS.$assignMove($Prm0.SS);
    this.Loc.$assignMove($Prm0.Loc);
    this.EllipsisLoc.$assignMove($Prm0.EllipsisLoc);
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public ParsedTemplateArgument clone() { return new ParsedTemplateArgument(this); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Arg=" + Arg // NOI18N
              + ", SS=" + SS // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", EllipsisLoc=" + EllipsisLoc; // NOI18N
  }
}
