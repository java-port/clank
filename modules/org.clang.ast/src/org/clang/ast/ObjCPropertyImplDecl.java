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
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


/// ObjCPropertyImplDecl - Represents implementation declaration of a property
/// in a class or category implementation block. For example:
/// \@synthesize prop1 = ivar1;
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2655,
 FQN="clang::ObjCPropertyImplDecl", NM="_ZN5clang20ObjCPropertyImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDeclE")
//</editor-fold>
public class ObjCPropertyImplDecl extends /*public*/ Decl implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2657,
   FQN="clang::ObjCPropertyImplDecl::Kind", NM="_ZN5clang20ObjCPropertyImplDecl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    Synthesize(0),
    Dynamic(Synthesize.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private SourceLocation AtLoc; // location of \@synthesize or \@dynamic
  
  /// \brief For \@synthesize, the location of the ivar, if it was written in
  /// the source code.
  ///
  /// \code
  /// \@synthesize int a = b
  /// \endcode
  /*friend*/public SourceLocation IvarLoc;
  
  /// Property declaration being implemented
  private ObjCPropertyDecl /*P*/ PropertyDecl;
  
  /// Null for \@dynamic. Required for \@synthesize.
  /*friend*/public ObjCIvarDecl /*P*/ PropertyIvarDecl;
  
  /// Null for \@dynamic. Non-null if property must be copy-constructed in
  /// getter.
  private Expr /*P*/ GetterCXXConstructor;
  
  /// Null for \@dynamic. Non-null if property has assignment operator to call
  /// in Setter synthesis.
  private Expr /*P*/ SetterCXXAssignment;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::ObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2686,
   FQN="clang::ObjCPropertyImplDecl::ObjCPropertyImplDecl", NM="_ZN5clang20ObjCPropertyImplDeclC1EPNS_11DeclContextENS_14SourceLocationES3_PNS_16ObjCPropertyDeclENS0_4KindEPNS_12ObjCIvarDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDeclC1EPNS_11DeclContextENS_14SourceLocationES3_PNS_16ObjCPropertyDeclENS0_4KindEPNS_12ObjCIvarDeclES3_")
  //</editor-fold>
  private ObjCPropertyImplDecl(DeclContext /*P*/ DC, SourceLocation atLoc, SourceLocation L, 
      ObjCPropertyDecl /*P*/ property, 
      Kind PK, 
      ObjCIvarDecl /*P*/ ivarDecl, 
      SourceLocation ivarLoc) {
    // : Decl(ObjCPropertyImpl, DC, L), AtLoc(atLoc), IvarLoc(ivarLoc), PropertyDecl(property), PropertyIvarDecl(ivarDecl), GetterCXXConstructor(null), SetterCXXAssignment(null) 
    //START JInit
    super(Decl.Kind.ObjCPropertyImpl, DC, new SourceLocation(L));
    this.AtLoc = new SourceLocation(atLoc);
    this.IvarLoc = new SourceLocation(ivarLoc);
    this.PropertyDecl = property;
    this.PropertyIvarDecl = ivarDecl;
    this.GetterCXXConstructor = null;
    this.SetterCXXAssignment = null;
    //END JInit
    assert (PK == Kind.Dynamic || (PropertyIvarDecl != null));
  }

/*public:*/
  
  //===----------------------------------------------------------------------===//
  // ObjCPropertyImplDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2188,
   FQN="clang::ObjCPropertyImplDecl::Create", NM="_ZN5clang20ObjCPropertyImplDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_16ObjCPropertyDeclENS0_4KindEPNS_12ObjCIvarDeclES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_PNS_16ObjCPropertyDeclENS0_4KindEPNS_12ObjCIvarDeclES5_")
  //</editor-fold>
  public static ObjCPropertyImplDecl /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation atLoc, 
        SourceLocation L, 
        ObjCPropertyDecl /*P*/ property, 
        Kind PK, 
        ObjCIvarDecl /*P*/ ivar, 
        SourceLocation ivarLoc) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ObjCPropertyImplDecl(DC, new SourceLocation(atLoc), new SourceLocation(L), property, PK, ivar, 
                new SourceLocation(ivarLoc));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2200,
   FQN="clang::ObjCPropertyImplDecl::CreateDeserialized", NM="_ZN5clang20ObjCPropertyImplDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCPropertyImplDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ObjCPropertyImplDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), (ObjCPropertyDecl /*P*/ )null, Kind.Dynamic, 
                (ObjCIvarDecl /*P*/ )null, new SourceLocation());
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2207,
   FQN="clang::ObjCPropertyImplDecl::getSourceRange", NM="_ZNK5clang20ObjCPropertyImplDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation EndLoc = getLocation();
    if (IvarLoc.isValid()) {
      EndLoc.$assign(IvarLoc);
    }
    
    return new SourceRange(/*NO_COPY*/AtLoc, /*NO_COPY*/EndLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2709,
   FQN="clang::ObjCPropertyImplDecl::getLocStart", NM="_ZNK5clang20ObjCPropertyImplDecl11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::setAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2710,
   FQN="clang::ObjCPropertyImplDecl::setAtLoc", NM="_ZN5clang20ObjCPropertyImplDecl8setAtLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl8setAtLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtLoc(SourceLocation Loc) {
    AtLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2712,
   FQN="clang::ObjCPropertyImplDecl::getPropertyDecl", NM="_ZNK5clang20ObjCPropertyImplDecl15getPropertyDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl15getPropertyDeclEv")
  //</editor-fold>
  public ObjCPropertyDecl /*P*/ getPropertyDecl() /*const*/ {
    return PropertyDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::setPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2715,
   FQN="clang::ObjCPropertyImplDecl::setPropertyDecl", NM="_ZN5clang20ObjCPropertyImplDecl15setPropertyDeclEPNS_16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl15setPropertyDeclEPNS_16ObjCPropertyDeclE")
  //</editor-fold>
  public void setPropertyDecl(ObjCPropertyDecl /*P*/ Prop) {
    PropertyDecl = Prop;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getPropertyImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2717,
   FQN="clang::ObjCPropertyImplDecl::getPropertyImplementation", NM="_ZNK5clang20ObjCPropertyImplDecl25getPropertyImplementationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl25getPropertyImplementationEv")
  //</editor-fold>
  public Kind getPropertyImplementation() /*const*/ {
    return (PropertyIvarDecl != null) ? Kind.Synthesize : Kind.Dynamic;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getPropertyIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2721,
   FQN="clang::ObjCPropertyImplDecl::getPropertyIvarDecl", NM="_ZNK5clang20ObjCPropertyImplDecl19getPropertyIvarDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl19getPropertyIvarDeclEv")
  //</editor-fold>
  public ObjCIvarDecl /*P*/ getPropertyIvarDecl() /*const*/ {
    return PropertyIvarDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getPropertyIvarDeclLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2724,
   FQN="clang::ObjCPropertyImplDecl::getPropertyIvarDeclLoc", NM="_ZNK5clang20ObjCPropertyImplDecl22getPropertyIvarDeclLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl22getPropertyIvarDeclLocEv")
  //</editor-fold>
  public SourceLocation getPropertyIvarDeclLoc() /*const*/ {
    return new SourceLocation(IvarLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::setPropertyIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2726,
   FQN="clang::ObjCPropertyImplDecl::setPropertyIvarDecl", NM="_ZN5clang20ObjCPropertyImplDecl19setPropertyIvarDeclEPNS_12ObjCIvarDeclENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl19setPropertyIvarDeclEPNS_12ObjCIvarDeclENS_14SourceLocationE")
  //</editor-fold>
  public void setPropertyIvarDecl(ObjCIvarDecl /*P*/ Ivar, 
                     SourceLocation IvarLoc) {
    PropertyIvarDecl = Ivar;
    this.IvarLoc.$assign(IvarLoc);
  }

  
  /// \brief For \@synthesize, returns true if an ivar name was explicitly
  /// specified.
  ///
  /// \code
  /// \@synthesize int a = b; // true
  /// \@synthesize int a; // false
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::isIvarNameSpecified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2739,
   FQN="clang::ObjCPropertyImplDecl::isIvarNameSpecified", NM="_ZNK5clang20ObjCPropertyImplDecl19isIvarNameSpecifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl19isIvarNameSpecifiedEv")
  //</editor-fold>
  public boolean isIvarNameSpecified() /*const*/ {
    return IvarLoc.isValid() && $noteq_SourceLocation$C(IvarLoc, getLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getGetterCXXConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2743,
   FQN="clang::ObjCPropertyImplDecl::getGetterCXXConstructor", NM="_ZNK5clang20ObjCPropertyImplDecl23getGetterCXXConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl23getGetterCXXConstructorEv")
  //</editor-fold>
  public Expr /*P*/ getGetterCXXConstructor() /*const*/ {
    return GetterCXXConstructor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::setGetterCXXConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2746,
   FQN="clang::ObjCPropertyImplDecl::setGetterCXXConstructor", NM="_ZN5clang20ObjCPropertyImplDecl23setGetterCXXConstructorEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl23setGetterCXXConstructorEPNS_4ExprE")
  //</editor-fold>
  public void setGetterCXXConstructor(Expr /*P*/ getterCXXConstructor) {
    GetterCXXConstructor = getterCXXConstructor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::getSetterCXXAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2750,
   FQN="clang::ObjCPropertyImplDecl::getSetterCXXAssignment", NM="_ZNK5clang20ObjCPropertyImplDecl22getSetterCXXAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCPropertyImplDecl22getSetterCXXAssignmentEv")
  //</editor-fold>
  public Expr /*P*/ getSetterCXXAssignment() /*const*/ {
    return SetterCXXAssignment;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::setSetterCXXAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2753,
   FQN="clang::ObjCPropertyImplDecl::setSetterCXXAssignment", NM="_ZN5clang20ObjCPropertyImplDecl22setSetterCXXAssignmentEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl22setSetterCXXAssignmentEPNS_4ExprE")
  //</editor-fold>
  public void setSetterCXXAssignment(Expr /*P*/ setterCXXAssignment) {
    SetterCXXAssignment = setterCXXAssignment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2757,
   FQN="clang::ObjCPropertyImplDecl::classof", NM="_ZN5clang20ObjCPropertyImplDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::classofKind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2758,
   FQN="clang::ObjCPropertyImplDecl::classofKind", NM="_ZN5clang20ObjCPropertyImplDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Decl.Kind K) {
    return K == Decl.Kind.ObjCPropertyImpl;
  }

  
  /*friend  class ASTDeclReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyImplDecl::~ObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2655,
   FQN="clang::ObjCPropertyImplDecl::~ObjCPropertyImplDecl", NM="_ZN5clang20ObjCPropertyImplDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCPropertyImplDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AtLoc=" + AtLoc // NOI18N
              + ", IvarLoc=" + IvarLoc // NOI18N
              + ", PropertyDecl=" + PropertyDecl // NOI18N
              + ", PropertyIvarDecl=" + PropertyIvarDecl // NOI18N
              + ", GetterCXXConstructor=" + GetterCXXConstructor // NOI18N
              + ", SetterCXXAssignment=" + SetterCXXAssignment // NOI18N
              + super.toString(); // NOI18N
  }
}
