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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// ObjCIvarDecl - Represents an ObjC instance variable. In general, ObjC
/// instance variables are identical to C. The only exception is Objective-C
/// supports C++ style access control. For example:
///
///   \@interface IvarExample : NSObject
///   {
///     id defaultToProtected;
///   \@public:
///     id canBePublic; // same as C++.
///   \@protected:
///     id canBeProtected; // same as C++.
///   \@package:
///     id canBePackage; // framework visibility (not available in C++).
///   }
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1849,
 FQN="clang::ObjCIvarDecl", NM="_ZN5clang12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDeclE")
//</editor-fold>
public class ObjCIvarDecl extends /*public*/ FieldDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCIvarDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1675,
   FQN="clang::ObjCIvarDecl::anchor", NM="_ZN5clang12ObjCIvarDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::AccessControl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1853,
   FQN="clang::ObjCIvarDecl::AccessControl", NM="_ZN5clang12ObjCIvarDecl13AccessControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl13AccessControlE")
  //</editor-fold>
  public enum AccessControl implements Native.ComparableLower {
    None(0),
    Private(None.getValue() + 1),
    Protected(Private.getValue() + 1),
    Public(Protected.getValue() + 1),
    Package(Public.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AccessControl valueOf(int val) {
      AccessControl out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AccessControl[] VALUES;
      private static final AccessControl[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AccessControl kind : AccessControl.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AccessControl[min < 0 ? (1-min) : 0];
        VALUES = new AccessControl[max >= 0 ? (1+max) : 0];
        for (AccessControl kind : AccessControl.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private AccessControl(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AccessControl)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AccessControl)obj).value);}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::ObjCIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1858,
   FQN="clang::ObjCIvarDecl::ObjCIvarDecl", NM="_ZN5clang12ObjCIvarDeclC1EPNS_17ObjCContainerDeclENS_14SourceLocationES3_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS0_13AccessControlEPNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDeclC1EPNS_17ObjCContainerDeclENS_14SourceLocationES3_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS0_13AccessControlEPNS_4ExprEb")
  //</editor-fold>
  private ObjCIvarDecl(ObjCContainerDecl /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
      QualType T, TypeSourceInfo /*P*/ TInfo, AccessControl ac, Expr /*P*/ BW, 
      boolean synthesized) {
    // : FieldDecl(ObjCIvar, DC, StartLoc, IdLoc, Id, T, TInfo, BW, /*Mutable=*/ false, /*HasInit=*/ ICIS_NoInit), NextIvar(null), DeclAccess(ac), Synthesized(synthesized) 
    //START JInit
    super(Kind.ObjCIvar, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, new QualType(T), TInfo, BW, 
        false, InClassInitStyle.ICIS_NoInit);
    this.NextIvar = null;
    this.DeclAccess = $uint2uint_3bits(ac.getValue());
    this.Synthesized = synthesized;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1677,
   FQN="clang::ObjCIvarDecl::Create", NM="_ZN5clang12ObjCIvarDecl6CreateERNS_10ASTContextEPNS_17ObjCContainerDeclENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS0_13AccessControlEPNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl6CreateERNS_10ASTContextEPNS_17ObjCContainerDeclENS_14SourceLocationES5_PNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoENS0_13AccessControlEPNS_4ExprEb")
  //</editor-fold>
  public static ObjCIvarDecl /*P*/ Create(final ASTContext /*&*/ C, ObjCContainerDecl /*P*/ DC, 
        SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        AccessControl ac) {
    return Create(C, DC, 
        StartLoc, 
        IdLoc, Id, 
        T, TInfo, 
        ac, (Expr /*P*/ )null, 
        false);
  }
  public static ObjCIvarDecl /*P*/ Create(final ASTContext /*&*/ C, ObjCContainerDecl /*P*/ DC, 
        SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        AccessControl ac, Expr /*P*/ BW/*= null*/) {
    return Create(C, DC, 
        StartLoc, 
        IdLoc, Id, 
        T, TInfo, 
        ac, BW, 
        false);
  }
  public static ObjCIvarDecl /*P*/ Create(final ASTContext /*&*/ C, ObjCContainerDecl /*P*/ DC, 
        SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        AccessControl ac, Expr /*P*/ BW/*= null*/, 
        boolean synthesized/*= false*/) {
    if ((DC != null)) {
      // Ivar's can only appear in interfaces, implementations (via synthesized
      // properties), and class extensions (via direct declaration, or synthesized
      // properties).
      //
      // FIXME: This should really be asserting this:
      //   (isa<ObjCCategoryDecl>(DC) &&
      //    cast<ObjCCategoryDecl>(DC)->IsClassExtension()))
      // but unfortunately we sometimes place ivars into non-class extension
      // categories on error. This breaks an AST invariant, and should not be
      // fixed.
      assert ((isa_ObjCInterfaceDecl(DC) || isa_ObjCImplementationDecl(DC) || isa_ObjCCategoryDecl(DC))) : "Invalid ivar decl context!";
      // Once a new ivar is created in any of class/class-extension/implementation
      // decl contexts, the previously built IvarList must be rebuilt.
      ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(DC);
      if (!(ID != null)) {
        {
          ObjCImplementationDecl /*P*/ IM = dyn_cast_ObjCImplementationDecl(DC);
          if ((IM != null)) {
            ID = IM.getClassInterface();
          } else {
            ID = cast_ObjCCategoryDecl(DC).getClassInterface();
          }
        }
      }
      ID.setIvarList((ObjCIvarDecl /*P*/ )null);
    }
    
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ObjCIvarDecl(DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, new QualType(T), TInfo, ac, BW, 
                synthesized);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1713,
   FQN="clang::ObjCIvarDecl::CreateDeserialized", NM="_ZN5clang12ObjCIvarDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCIvarDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ObjCIvarDecl((ObjCContainerDecl /*P*/ )null, new SourceLocation(), new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, new QualType(), (TypeSourceInfo /*P*/ )null, 
                ObjCIvarDecl.AccessControl.None, (Expr /*P*/ )null, false);
     });
  }

  
  /// \brief Return the class interface that this ivar is logically contained
  /// in; this is either the interface where the ivar was declared, or the
  /// interface the ivar is conceptually a part of in the case of synthesized
  /// ivars.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::getContainingInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1719,
   FQN="clang::ObjCIvarDecl::getContainingInterface", NM="_ZNK5clang12ObjCIvarDecl22getContainingInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCIvarDecl22getContainingInterfaceEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getContainingInterface() /*const*/ {
    /*const*/ ObjCContainerDecl /*P*/ DC = cast_ObjCContainerDecl(getDeclContext$Const());
    switch (DC.getKind()) {
     default:
     case ObjCCategoryImpl:
     case ObjCProtocol:
      throw new llvm_unreachable("invalid ivar container!");
     case ObjCCategory:
      {
        /*const*/ ObjCCategoryDecl /*P*/ CD = cast_ObjCCategoryDecl(DC);
        assert (CD.IsClassExtension()) : "invalid container for ivar!";
        return CD.getClassInterface$Const();
      }
     case ObjCImplementation:
      return cast_ObjCImplementationDecl(DC).getClassInterface$Const();
     case ObjCInterface:
      return cast_ObjCInterfaceDecl(DC);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::getNextIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1882,
   FQN="clang::ObjCIvarDecl::getNextIvar", NM="_ZN5clang12ObjCIvarDecl11getNextIvarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl11getNextIvarEv")
  //</editor-fold>
  public ObjCIvarDecl /*P*/ getNextIvar() {
    return NextIvar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::getNextIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1883,
   FQN="clang::ObjCIvarDecl::getNextIvar", NM="_ZNK5clang12ObjCIvarDecl11getNextIvarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCIvarDecl11getNextIvarEv")
  //</editor-fold>
  public /*const*/ ObjCIvarDecl /*P*/ getNextIvar$Const() /*const*/ {
    return NextIvar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::setNextIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1884,
   FQN="clang::ObjCIvarDecl::setNextIvar", NM="_ZN5clang12ObjCIvarDecl11setNextIvarEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl11setNextIvarEPS0_")
  //</editor-fold>
  public void setNextIvar(ObjCIvarDecl /*P*/ ivar) {
    NextIvar = ivar;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::setAccessControl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1886,
   FQN="clang::ObjCIvarDecl::setAccessControl", NM="_ZN5clang12ObjCIvarDecl16setAccessControlENS0_13AccessControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl16setAccessControlENS0_13AccessControlE")
  //</editor-fold>
  public void setAccessControl(AccessControl ac) {
    DeclAccess = $uint2uint_3bits(ac.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::getAccessControl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1888,
   FQN="clang::ObjCIvarDecl::getAccessControl", NM="_ZNK5clang12ObjCIvarDecl16getAccessControlEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCIvarDecl16getAccessControlEv")
  //</editor-fold>
  public AccessControl getAccessControl() /*const*/ {
    return AccessControl.valueOf(DeclAccess);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::getCanonicalAccessControl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1890,
   FQN="clang::ObjCIvarDecl::getCanonicalAccessControl", NM="_ZNK5clang12ObjCIvarDecl25getCanonicalAccessControlEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCIvarDecl25getCanonicalAccessControlEv")
  //</editor-fold>
  public AccessControl getCanonicalAccessControl() /*const*/ {
    return DeclAccess == $int2uint_3bits(AccessControl.None.getValue()) ? AccessControl.Protected : AccessControl.valueOf(DeclAccess);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::setSynthesize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1894,
   FQN="clang::ObjCIvarDecl::setSynthesize", NM="_ZN5clang12ObjCIvarDecl13setSynthesizeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl13setSynthesizeEb")
  //</editor-fold>
  public void setSynthesize(boolean synth) {
    Synthesized = synth;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::getSynthesize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1895,
   FQN="clang::ObjCIvarDecl::getSynthesize", NM="_ZNK5clang12ObjCIvarDecl13getSynthesizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCIvarDecl13getSynthesizeEv")
  //</editor-fold>
  public boolean getSynthesize() /*const*/ {
    return Synthesized;
  }

  
  /// Retrieve the type of this instance variable when viewed as a member of a
  /// specific object type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::getUsageType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1743,
   FQN="clang::ObjCIvarDecl::getUsageType", NM="_ZNK5clang12ObjCIvarDecl12getUsageTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCIvarDecl12getUsageTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getUsageType(QualType objectType) /*const*/ {
    return getType().substObjCMemberType(new QualType(objectType), getDeclContext$Const(), 
        ObjCSubstitutionContext.Property);
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1902,
   FQN="clang::ObjCIvarDecl::classof", NM="_ZN5clang12ObjCIvarDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1903,
   FQN="clang::ObjCIvarDecl::classofKind", NM="_ZN5clang12ObjCIvarDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCIvar;
  }

/*private:*/
  /// NextIvar - Next Ivar in the list of ivars declared in class; class's
  /// extensions and class's implementation
  private ObjCIvarDecl /*P*/ NextIvar;
  
  // NOTE: VC++ treats enums as signed, avoid using the AccessControl enum
  private /*JBYTE unsigned int*/ byte DeclAccess /*: 3*/;
  private /*JBIT unsigned int*/ boolean Synthesized /*: 1*/;
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCIvarDecl::~ObjCIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1849,
   FQN="clang::ObjCIvarDecl::~ObjCIvarDecl", NM="_ZN5clang12ObjCIvarDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCIvarDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "NextIvar=" + NextIvar // NOI18N
              + ", DeclAccess=" + $uchar2uint(DeclAccess) // NOI18N
              + ", Synthesized=" + Synthesized // NOI18N
              + super.toString(); // NOI18N
  }
}
