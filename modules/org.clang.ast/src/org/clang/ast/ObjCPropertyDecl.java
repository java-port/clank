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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Represents one property declaration in an Objective-C interface.
///
/// For example:
/// \code{.mm}
/// \@property (assign, readwrite) int MyProperty;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 699,
 FQN="clang::ObjCPropertyDecl", NM="_ZN5clang16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDeclE")
//</editor-fold>
public class ObjCPropertyDecl extends /*public*/ NamedDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCPropertyDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2158,
   FQN="clang::ObjCPropertyDecl::anchor", NM="_ZN5clang16ObjCPropertyDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::PropertyAttributeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 702,
   FQN="clang::ObjCPropertyDecl::PropertyAttributeKind", NM="_ZN5clang16ObjCPropertyDecl21PropertyAttributeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl21PropertyAttributeKindE")
  //</editor-fold>
  public static final class/*enum*/ PropertyAttributeKind {
    public static final /*uint*/int OBJC_PR_noattr = 0x00;
    public static final /*uint*/int OBJC_PR_readonly = 0x01;
    public static final /*uint*/int OBJC_PR_getter = 0x02;
    public static final /*uint*/int OBJC_PR_assign = 0x04;
    public static final /*uint*/int OBJC_PR_readwrite = 0x08;
    public static final /*uint*/int OBJC_PR_retain = 0x10;
    public static final /*uint*/int OBJC_PR_copy = 0x20;
    public static final /*uint*/int OBJC_PR_nonatomic = 0x40;
    public static final /*uint*/int OBJC_PR_setter = 0x80;
    public static final /*uint*/int OBJC_PR_atomic = 0x100;
    public static final /*uint*/int OBJC_PR_weak = 0x200;
    public static final /*uint*/int OBJC_PR_strong = 0x400;
    public static final /*uint*/int OBJC_PR_unsafe_unretained = 0x800;
    /// Indicates that the nullability of the type was spelled with a
    /// property attribute rather than a type qualifier.
    public static final /*uint*/int OBJC_PR_nullability = 0x1000;
    public static final /*uint*/int OBJC_PR_null_resettable = 0x2000;
    public static final /*uint*/int OBJC_PR_class = 0x4000;
    // Adding a property should change NumPropertyAttrsBits
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 724,
   FQN="clang::ObjCPropertyDecl::(anonymous)", NM="_ZN5clang16ObjCPropertyDeclE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDeclE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// \brief Number of bits fitting all the property attributes.
    public static final /*uint*/int NumPropertyAttrsBits = 15;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::SetterKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 729,
   FQN="clang::ObjCPropertyDecl::SetterKind", NM="_ZN5clang16ObjCPropertyDecl10SetterKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl10SetterKindE")
  //</editor-fold>
  public enum SetterKind implements Native.ComparableLower {
    Assign(0),
    Retain(Assign.getValue() + 1),
    Copy(Retain.getValue() + 1),
    Weak(Copy.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SetterKind valueOf(int val) {
      SetterKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SetterKind[] VALUES;
      private static final SetterKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SetterKind kind : SetterKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SetterKind[min < 0 ? (1-min) : 0];
        VALUES = new SetterKind[max >= 0 ? (1+max) : 0];
        for (SetterKind kind : SetterKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SetterKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SetterKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SetterKind)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::PropertyControl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 730,
   FQN="clang::ObjCPropertyDecl::PropertyControl", NM="_ZN5clang16ObjCPropertyDecl15PropertyControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl15PropertyControlE")
  //</editor-fold>
  public enum PropertyControl implements Native.ComparableLower {
    None(0),
    Required(None.getValue() + 1),
    Optional(Required.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PropertyControl valueOf(int val) {
      PropertyControl out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PropertyControl[] VALUES;
      private static final PropertyControl[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PropertyControl kind : PropertyControl.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PropertyControl[min < 0 ? (1-min) : 0];
        VALUES = new PropertyControl[max >= 0 ? (1+max) : 0];
        for (PropertyControl kind : PropertyControl.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private PropertyControl(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((PropertyControl)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((PropertyControl)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private SourceLocation AtLoc; // location of \@property
  private SourceLocation LParenLoc; // location of '(' starting attribute list or null.
  private QualType DeclType;
  private TypeSourceInfo /*P*/ DeclTypeSourceInfo;
  private /*JCHAR unsigned int*/ char PropertyAttributes /*: NumPropertyAttrsBits*/;
  private /*JCHAR unsigned int*/ char PropertyAttributesAsWritten /*: NumPropertyAttrsBits*/;
  // \@required/\@optional
  private /*JBYTE unsigned int*/ byte PropertyImplementation /*: 2*/;
  
  private Selector GetterName; // getter name of NULL if no getter
  private Selector SetterName; // setter name of NULL if no setter
  
  private ObjCMethodDecl /*P*/ GetterMethodDecl; // Declaration of getter instance method
  private ObjCMethodDecl /*P*/ SetterMethodDecl; // Declaration of setter instance method
  private ObjCIvarDecl /*P*/ PropertyIvarDecl; // Synthesize ivar for this property
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::ObjCPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 748,
   FQN="clang::ObjCPropertyDecl::ObjCPropertyDecl", NM="_ZN5clang16ObjCPropertyDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES3_S3_NS_8QualTypeEPNS_14TypeSourceInfoENS0_15PropertyControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES3_S3_NS_8QualTypeEPNS_14TypeSourceInfoENS0_15PropertyControlE")
  //</editor-fold>
  private ObjCPropertyDecl(DeclContext /*P*/ DC, SourceLocation L, IdentifierInfo /*P*/ Id, 
      SourceLocation AtLocation, SourceLocation LParenLocation, 
      QualType T, TypeSourceInfo /*P*/ TSI, 
      PropertyControl propControl) {
    // : NamedDecl(ObjCProperty, DC, L, Id), AtLoc(AtLocation), LParenLoc(LParenLocation), DeclType(T), DeclTypeSourceInfo(TSI), PropertyAttributes(OBJC_PR_noattr), PropertyAttributesAsWritten(OBJC_PR_noattr), PropertyImplementation(propControl), GetterName(Selector()), SetterName(Selector()), GetterMethodDecl(null), SetterMethodDecl(null), PropertyIvarDecl(null) 
    //START JInit
    super(Kind.ObjCProperty, DC, new SourceLocation(L), new DeclarationName(Id));
    this.AtLoc = new SourceLocation(AtLocation);
    this.LParenLoc = new SourceLocation(LParenLocation);
    this.DeclType = new QualType(T);
    this.DeclTypeSourceInfo = TSI;
    this.PropertyAttributes = $uint2uint_15bits(PropertyAttributeKind.OBJC_PR_noattr);
    this.PropertyAttributesAsWritten = $uint2uint_15bits(PropertyAttributeKind.OBJC_PR_noattr);
    this.PropertyImplementation = $uint2uint_2bits(propControl.getValue());
    this.GetterName = new Selector();
    this.SetterName = new Selector();
    this.GetterMethodDecl = null;
    this.SetterMethodDecl = null;
    this.PropertyIvarDecl = null;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2160,
   FQN="clang::ObjCPropertyDecl::Create", NM="_ZN5clang16ObjCPropertyDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES5_S5_NS_8QualTypeEPNS_14TypeSourceInfoENS0_15PropertyControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES5_S5_NS_8QualTypeEPNS_14TypeSourceInfoENS0_15PropertyControlE")
  //</editor-fold>
  public static ObjCPropertyDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, 
        IdentifierInfo /*P*/ Id, 
        SourceLocation AtLoc, 
        SourceLocation LParenLoc, 
        QualType T, 
        TypeSourceInfo /*P*/ TSI) {
    return Create(C, DC, 
        L, 
        Id, 
        AtLoc, 
        LParenLoc, 
        T, 
        TSI, 
        PropertyControl.None);
  }
  public static ObjCPropertyDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, 
        IdentifierInfo /*P*/ Id, 
        SourceLocation AtLoc, 
        SourceLocation LParenLoc, 
        QualType T, 
        TypeSourceInfo /*P*/ TSI, 
        PropertyControl propControl/*= None*/) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ObjCPropertyDecl(DC, new SourceLocation(L), Id, new SourceLocation(AtLoc), new SourceLocation(LParenLoc), new QualType(T), TSI, 
                propControl);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2172,
   FQN="clang::ObjCPropertyDecl::CreateDeserialized", NM="_ZN5clang16ObjCPropertyDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCPropertyDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ObjCPropertyDecl((DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
                new SourceLocation(), new SourceLocation(), 
                new QualType(), (TypeSourceInfo /*P*/ )null, PropertyControl.None);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 773,
   FQN="clang::ObjCPropertyDecl::getAtLoc", NM="_ZNK5clang16ObjCPropertyDecl8getAtLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl8getAtLocEv")
  //</editor-fold>
  public SourceLocation getAtLoc() /*const*/ {
    return new SourceLocation(AtLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setAtLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 774,
   FQN="clang::ObjCPropertyDecl::setAtLoc", NM="_ZN5clang16ObjCPropertyDecl8setAtLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl8setAtLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtLoc(SourceLocation L) {
    AtLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 776,
   FQN="clang::ObjCPropertyDecl::getLParenLoc", NM="_ZNK5clang16ObjCPropertyDecl12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() /*const*/ {
    return new SourceLocation(LParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 777,
   FQN="clang::ObjCPropertyDecl::setLParenLoc", NM="_ZN5clang16ObjCPropertyDecl12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLParenLoc(SourceLocation L) {
    LParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 779,
   FQN="clang::ObjCPropertyDecl::getTypeSourceInfo", NM="_ZNK5clang16ObjCPropertyDecl17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return DeclTypeSourceInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 781,
   FQN="clang::ObjCPropertyDecl::getType", NM="_ZNK5clang16ObjCPropertyDecl7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return new QualType(DeclType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 783,
   FQN="clang::ObjCPropertyDecl::setType", NM="_ZN5clang16ObjCPropertyDecl7setTypeENS_8QualTypeEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl7setTypeENS_8QualTypeEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setType(QualType T, TypeSourceInfo /*P*/ TSI) {
    DeclType.$assign(T);
    DeclTypeSourceInfo = TSI;
  }

  
  /// Retrieve the type when this property is used with a specific base object
  /// type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getUsageType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2179,
   FQN="clang::ObjCPropertyDecl::getUsageType", NM="_ZNK5clang16ObjCPropertyDecl12getUsageTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl12getUsageTypeENS_8QualTypeE")
  //</editor-fold>
  public QualType getUsageType(QualType objectType) /*const*/ {
    return DeclType.substObjCMemberType(new QualType(objectType), getDeclContext$Const(), 
        ObjCSubstitutionContext.Property);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getPropertyAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 792,
   FQN="clang::ObjCPropertyDecl::getPropertyAttributes", NM="_ZNK5clang16ObjCPropertyDecl21getPropertyAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl21getPropertyAttributesEv")
  //</editor-fold>
  public /*PropertyAttributeKind*//*uint*/int getPropertyAttributes() /*const*/ {
    return ((/*PropertyAttributeKind*//*uint*/int)(PropertyAttributes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setPropertyAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 795,
   FQN="clang::ObjCPropertyDecl::setPropertyAttributes", NM="_ZN5clang16ObjCPropertyDecl21setPropertyAttributesENS0_21PropertyAttributeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl21setPropertyAttributesENS0_21PropertyAttributeKindE")
  //</editor-fold>
  public void setPropertyAttributes(/*PropertyAttributeKind*//*uint*/int PRVal) {
    PropertyAttributes |= $int2uint_15bits(PRVal);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::overwritePropertyAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 798,
   FQN="clang::ObjCPropertyDecl::overwritePropertyAttributes", NM="_ZN5clang16ObjCPropertyDecl27overwritePropertyAttributesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl27overwritePropertyAttributesEj")
  //</editor-fold>
  public void overwritePropertyAttributes(/*uint*/int PRVal) {
    PropertyAttributes = $uint2uint_15bits(PRVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getPropertyAttributesAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 802,
   FQN="clang::ObjCPropertyDecl::getPropertyAttributesAsWritten", NM="_ZNK5clang16ObjCPropertyDecl30getPropertyAttributesAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl30getPropertyAttributesAsWrittenEv")
  //</editor-fold>
  public /*PropertyAttributeKind*//*uint*/int getPropertyAttributesAsWritten() /*const*/ {
    return ((/*PropertyAttributeKind*//*uint*/int)(PropertyAttributesAsWritten));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setPropertyAttributesAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 806,
   FQN="clang::ObjCPropertyDecl::setPropertyAttributesAsWritten", NM="_ZN5clang16ObjCPropertyDecl30setPropertyAttributesAsWrittenENS0_21PropertyAttributeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl30setPropertyAttributesAsWrittenENS0_21PropertyAttributeKindE")
  //</editor-fold>
  public void setPropertyAttributesAsWritten(/*PropertyAttributeKind*//*uint*/int PRVal) {
    PropertyAttributesAsWritten = $uint2uint_15bits(PRVal);
  }

  
  // Helper methods for accessing attributes.
  
  /// isReadOnly - Return true iff the property has a setter.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::isReadOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 813,
   FQN="clang::ObjCPropertyDecl::isReadOnly", NM="_ZNK5clang16ObjCPropertyDecl10isReadOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl10isReadOnlyEv")
  //</editor-fold>
  public boolean isReadOnly() /*const*/ {
    return ((PropertyAttributes & $int2uint_15bits(PropertyAttributeKind.OBJC_PR_readonly)) != 0);
  }

  
  /// isAtomic - Return true if the property is atomic.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::isAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 818,
   FQN="clang::ObjCPropertyDecl::isAtomic", NM="_ZNK5clang16ObjCPropertyDecl8isAtomicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl8isAtomicEv")
  //</editor-fold>
  public boolean isAtomic() /*const*/ {
    return ((PropertyAttributes & $int2uint_15bits(PropertyAttributeKind.OBJC_PR_atomic)) != 0);
  }

  
  /// isRetaining - Return true if the property retains its value.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::isRetaining">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 823,
   FQN="clang::ObjCPropertyDecl::isRetaining", NM="_ZNK5clang16ObjCPropertyDecl11isRetainingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl11isRetainingEv")
  //</editor-fold>
  public boolean isRetaining() /*const*/ {
    return ((PropertyAttributes
       & $int2uint_15bits((PropertyAttributeKind.OBJC_PR_retain | PropertyAttributeKind.OBJC_PR_strong | PropertyAttributeKind.OBJC_PR_copy))) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::isInstanceProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 828,
   FQN="clang::ObjCPropertyDecl::isInstanceProperty", NM="_ZNK5clang16ObjCPropertyDecl18isInstancePropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl18isInstancePropertyEv")
  //</editor-fold>
  public boolean isInstanceProperty() /*const*/ {
    return !isClassProperty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::isClassProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 829,
   FQN="clang::ObjCPropertyDecl::isClassProperty", NM="_ZNK5clang16ObjCPropertyDecl15isClassPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl15isClassPropertyEv")
  //</editor-fold>
  public boolean isClassProperty() /*const*/ {
    return ((PropertyAttributes & $int2uint_15bits(PropertyAttributeKind.OBJC_PR_class)) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getQueryKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 830,
   FQN="clang::ObjCPropertyDecl::getQueryKind", NM="_ZNK5clang16ObjCPropertyDecl12getQueryKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl12getQueryKindEv")
  //</editor-fold>
  public /*ObjCPropertyQueryKind*/byte/*uint8_t*/ getQueryKind() /*const*/ {
    return isClassProperty() ? ObjCPropertyQueryKind.OBJC_PR_query_class : ObjCPropertyQueryKind.OBJC_PR_query_instance;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getQueryKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 834,
   FQN="clang::ObjCPropertyDecl::getQueryKind", NM="_ZN5clang16ObjCPropertyDecl12getQueryKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl12getQueryKindEb")
  //</editor-fold>
  public static /*ObjCPropertyQueryKind*/byte/*uint8_t*/ getQueryKind(boolean isClassProperty) {
    return isClassProperty ? ObjCPropertyQueryKind.OBJC_PR_query_class : ObjCPropertyQueryKind.OBJC_PR_query_instance;
  }

  
  /// getSetterKind - Return the method used for doing assignment in
  /// the property setter. This is only valid if the property has been
  /// defined to have a setter.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getSetterKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 842,
   FQN="clang::ObjCPropertyDecl::getSetterKind", NM="_ZNK5clang16ObjCPropertyDecl13getSetterKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl13getSetterKindEv")
  //</editor-fold>
  public SetterKind getSetterKind() /*const*/ {
    if (((PropertyAttributes & $int2uint_15bits(PropertyAttributeKind.OBJC_PR_strong)) != 0)) {
      return getType().$arrow().isBlockPointerType() ? SetterKind.Copy : SetterKind.Retain;
    }
    if (((PropertyAttributes & $int2uint_15bits(PropertyAttributeKind.OBJC_PR_retain)) != 0)) {
      return SetterKind.Retain;
    }
    if (((PropertyAttributes & $int2uint_15bits(PropertyAttributeKind.OBJC_PR_copy)) != 0)) {
      return SetterKind.Copy;
    }
    if (((PropertyAttributes & $int2uint_15bits(PropertyAttributeKind.OBJC_PR_weak)) != 0)) {
      return SetterKind.Weak;
    }
    return SetterKind.Assign;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getGetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 854,
   FQN="clang::ObjCPropertyDecl::getGetterName", NM="_ZNK5clang16ObjCPropertyDecl13getGetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl13getGetterNameEv")
  //</editor-fold>
  public Selector getGetterName() /*const*/ {
    return new Selector(GetterName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setGetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 855,
   FQN="clang::ObjCPropertyDecl::setGetterName", NM="_ZN5clang16ObjCPropertyDecl13setGetterNameENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl13setGetterNameENS_8SelectorE")
  //</editor-fold>
  public void setGetterName(Selector Sel) {
    GetterName.$assign(Sel);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 857,
   FQN="clang::ObjCPropertyDecl::getSetterName", NM="_ZNK5clang16ObjCPropertyDecl13getSetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl13getSetterNameEv")
  //</editor-fold>
  public Selector getSetterName() /*const*/ {
    return new Selector(SetterName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 858,
   FQN="clang::ObjCPropertyDecl::setSetterName", NM="_ZN5clang16ObjCPropertyDecl13setSetterNameENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl13setSetterNameENS_8SelectorE")
  //</editor-fold>
  public void setSetterName(Selector Sel) {
    SetterName.$assign(Sel);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getGetterMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 860,
   FQN="clang::ObjCPropertyDecl::getGetterMethodDecl", NM="_ZNK5clang16ObjCPropertyDecl19getGetterMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl19getGetterMethodDeclEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getGetterMethodDecl() /*const*/ {
    return GetterMethodDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setGetterMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 861,
   FQN="clang::ObjCPropertyDecl::setGetterMethodDecl", NM="_ZN5clang16ObjCPropertyDecl19setGetterMethodDeclEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl19setGetterMethodDeclEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void setGetterMethodDecl(ObjCMethodDecl /*P*/ gDecl) {
    GetterMethodDecl = gDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getSetterMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 863,
   FQN="clang::ObjCPropertyDecl::getSetterMethodDecl", NM="_ZNK5clang16ObjCPropertyDecl19getSetterMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl19getSetterMethodDeclEv")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getSetterMethodDecl() /*const*/ {
    return SetterMethodDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setSetterMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 864,
   FQN="clang::ObjCPropertyDecl::setSetterMethodDecl", NM="_ZN5clang16ObjCPropertyDecl19setSetterMethodDeclEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl19setSetterMethodDeclEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void setSetterMethodDecl(ObjCMethodDecl /*P*/ gDecl) {
    SetterMethodDecl = gDecl;
  }

  
  // Related to \@optional/\@required declared in \@protocol
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setPropertyImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 867,
   FQN="clang::ObjCPropertyDecl::setPropertyImplementation", NM="_ZN5clang16ObjCPropertyDecl25setPropertyImplementationENS0_15PropertyControlE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl25setPropertyImplementationENS0_15PropertyControlE")
  //</editor-fold>
  public void setPropertyImplementation(PropertyControl pc) {
    PropertyImplementation = $uint2uint_2bits(pc.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getPropertyImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 870,
   FQN="clang::ObjCPropertyDecl::getPropertyImplementation", NM="_ZNK5clang16ObjCPropertyDecl25getPropertyImplementationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl25getPropertyImplementationEv")
  //</editor-fold>
  public PropertyControl getPropertyImplementation() /*const*/ {
    return PropertyControl.valueOf(PropertyImplementation);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::setPropertyIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 874,
   FQN="clang::ObjCPropertyDecl::setPropertyIvarDecl", NM="_ZN5clang16ObjCPropertyDecl19setPropertyIvarDeclEPNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl19setPropertyIvarDeclEPNS_12ObjCIvarDeclE")
  //</editor-fold>
  public void setPropertyIvarDecl(ObjCIvarDecl /*P*/ Ivar) {
    PropertyIvarDecl = Ivar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getPropertyIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 877,
   FQN="clang::ObjCPropertyDecl::getPropertyIvarDecl", NM="_ZNK5clang16ObjCPropertyDecl19getPropertyIvarDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl19getPropertyIvarDeclEv")
  //</editor-fold>
  public ObjCIvarDecl /*P*/ getPropertyIvarDecl() /*const*/ {
    return PropertyIvarDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 881,
   FQN="clang::ObjCPropertyDecl::getSourceRange", NM="_ZNK5clang16ObjCPropertyDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(/*NO_COPY*/AtLoc, getLocation());
  }

  
  /// Get the default name of the synthesized ivar.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::getDefaultSynthIvarName">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 201,
   FQN="clang::ObjCPropertyDecl::getDefaultSynthIvarName", NM="_ZNK5clang16ObjCPropertyDecl23getDefaultSynthIvarNameERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCPropertyDecl23getDefaultSynthIvarNameERNS_10ASTContextE")
  //</editor-fold>
  public IdentifierInfo /*P*/ getDefaultSynthIvarName(final ASTContext /*&*/ Ctx) /*const*/ {
    SmallString/*128*/ ivarName/*J*/= new SmallString/*128*/(128);
    {
      raw_svector_ostream os = null;
      try {
        os/*J*/= new raw_svector_ostream(ivarName);
        os.$out_char($$UNDERSCORE).$out(getIdentifier().getName());
      } finally {
        if (os != null) { os.$destroy(); }
      }
    }
    return $AddrOf(Ctx.Idents.get(/*JAVA: PERF*/ivarName/*.str()*/));
  }

  
  /// Lookup a property by name in the specified DeclContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::findPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 153,
   FQN="clang::ObjCPropertyDecl::findPropertyDecl", NM="_ZN5clang16ObjCPropertyDecl16findPropertyDeclEPKNS_11DeclContextEPKNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl16findPropertyDeclEPKNS_11DeclContextEPKNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE")
  //</editor-fold>
  public static ObjCPropertyDecl /*P*/ findPropertyDecl(/*const*/ DeclContext /*P*/ DC, 
                  /*const*/ IdentifierInfo /*P*/ propertyID, 
                  /*ObjCPropertyQueryKind*/byte/*uint8_t*/ queryKind) {
    {
      // If this context is a hidden protocol definition, don't find any
      // property.
      /*const*/ ObjCProtocolDecl /*P*/ Proto = dyn_cast_ObjCProtocolDecl(DC);
      if ((Proto != null)) {
        {
          /*const*/ ObjCProtocolDecl /*P*/ Def = Proto.getDefinition$Const();
          if ((Def != null)) {
            if (Def.isHidden()) {
              return null;
            }
          }
        }
      }
    }
    {
      
      // If context is class, then lookup property in its extensions.
      // This comes before property is looked up in primary class.
      /*const*/ ObjCInterfaceDecl /*P*/ IDecl = dyn_cast_ObjCInterfaceDecl(DC);
      if ((IDecl != null)) {
        for (/*const*/ ObjCCategoryDecl /*P*/ Ext : IDecl.known_extensions())  {
          {
            ObjCPropertyDecl /*P*/ PD = ObjCPropertyDecl.findPropertyDecl(Ext, 
                propertyID, 
                queryKind);
            if ((PD != null)) {
              return PD;
            }
          }
        }
      }
    }
    
    DeclContextLookupResult R = DC.lookup(new DeclarationName(propertyID));
    ObjCPropertyDecl /*P*/ classProp = null;
    for (DeclContextLookupResult.iterator I = R.begin(), E = R.end(); I.$noteq(E);
         I.$preInc())  {
      {
        ObjCPropertyDecl /*P*/ PD = dyn_cast_ObjCPropertyDecl(I.$star());
        if ((PD != null)) {
          // If queryKind is unknown, we return the instance property if one
          // exists; otherwise we return the class property.
          if ((queryKind == ObjCPropertyQueryKind.OBJC_PR_query_unknown
             && !PD.isClassProperty())
             || (queryKind == ObjCPropertyQueryKind.OBJC_PR_query_class
             && PD.isClassProperty())
             || (queryKind == ObjCPropertyQueryKind.OBJC_PR_query_instance
             && !PD.isClassProperty())) {
            return PD;
          }
          if (PD.isClassProperty()) {
            classProp = PD;
          }
        }
      }
    }
    if (queryKind == ObjCPropertyQueryKind.OBJC_PR_query_unknown) {
      // We can't find the instance property, return the class property.
      return classProp;
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 893,
   FQN="clang::ObjCPropertyDecl::classof", NM="_ZN5clang16ObjCPropertyDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 894,
   FQN="clang::ObjCPropertyDecl::classofKind", NM="_ZN5clang16ObjCPropertyDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCProperty;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCPropertyDecl::~ObjCPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 699,
   FQN="clang::ObjCPropertyDecl::~ObjCPropertyDecl", NM="_ZN5clang16ObjCPropertyDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCPropertyDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AtLoc=" + AtLoc // NOI18N
              + ", LParenLoc=" + LParenLoc // NOI18N
              + ", DeclType=" + DeclType // NOI18N
              + ", DeclTypeSourceInfo=" + DeclTypeSourceInfo // NOI18N
              + ", PropertyAttributes=" + $ushort2uint(PropertyAttributes) // NOI18N
              + ", PropertyAttributesAsWritten=" + $ushort2uint(PropertyAttributesAsWritten) // NOI18N
              + ", PropertyImplementation=" + $uchar2uint(PropertyImplementation) // NOI18N
              + ", GetterName=" + GetterName // NOI18N
              + ", SetterName=" + SetterName // NOI18N
              + ", GetterMethodDecl=" + GetterMethodDecl // NOI18N
              + ", SetterMethodDecl=" + SetterMethodDecl // NOI18N
              + ", PropertyIvarDecl=" + PropertyIvarDecl // NOI18N
              + super.toString(); // NOI18N
  }
}
