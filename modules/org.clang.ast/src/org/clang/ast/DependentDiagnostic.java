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
import org.clang.basic.*;
import static org.clang.ast.ASTContextGlobals.*;


/// A dependently-generated diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 34,
 FQN="clang::DependentDiagnostic", NM="_ZN5clang19DependentDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnosticE")
//</editor-fold>
public class DependentDiagnostic implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::AccessNonce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 36,
   FQN="clang::DependentDiagnostic::AccessNonce", NM="_ZN5clang19DependentDiagnostic11AccessNonceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnostic11AccessNonceE")
  //</editor-fold>
  public enum AccessNonce implements Native.ComparableLower {
    Access(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AccessNonce valueOf(int val) {
      AccessNonce out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AccessNonce[] VALUES;
      private static final AccessNonce[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AccessNonce kind : AccessNonce.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AccessNonce[min < 0 ? (1-min) : 0];
        VALUES = new AccessNonce[max >= 0 ? (1+max) : 0];
        for (AccessNonce kind : AccessNonce.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private AccessNonce(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AccessNonce)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AccessNonce)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 38,
   FQN="clang::DependentDiagnostic::Create", NM="_ZN5clang19DependentDiagnostic6CreateERNS_10ASTContextEPNS_11DeclContextENS0_11AccessNonceENS_14SourceLocationEbNS_15AccessSpecifierEPNS_9NamedDeclEPNS_13CXXRecordDeclENS_8QualTypeERKNS_17PartialDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnostic6CreateERNS_10ASTContextEPNS_11DeclContextENS0_11AccessNonceENS_14SourceLocationEbNS_15AccessSpecifierEPNS_9NamedDeclEPNS_13CXXRecordDeclENS_8QualTypeERKNS_17PartialDiagnosticE")
  //</editor-fold>
  public static DependentDiagnostic /*P*/ Create(final ASTContext /*&*/ Context, 
        DeclContext /*P*/ Parent, 
        AccessNonce _, 
        SourceLocation Loc, 
        boolean IsMemberAccess, 
        AccessSpecifier AS, 
        NamedDecl /*P*/ TargetDecl, 
        CXXRecordDecl /*P*/ NamingClass, 
        QualType BaseObjectType, 
        final /*const*/ PartialDiagnostic /*&*/ PDiag) {
    DependentDiagnostic /*P*/ DD = Create(Context, Parent, PDiag);
    DD.AccessData.Loc = Loc.getRawEncoding();
    DD.AccessData.IsMember = IsMemberAccess;
    DD.AccessData.Access = $uint2uint_2bits(AS.getValue());
    DD.AccessData.TargetDecl = TargetDecl;
    DD.AccessData.NamingClass = NamingClass;
    DD.AccessData.BaseObjectType = BaseObjectType.getAsOpaquePtr();
    return DD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 58,
   FQN="clang::DependentDiagnostic::getKind", NM="_ZNK5clang19DependentDiagnostic7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic7getKindEv")
  //</editor-fold>
  public /*uint*/int getKind() /*const*/ {
    return AccessNonce.Access.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::isAccessToMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 62,
   FQN="clang::DependentDiagnostic::isAccessToMember", NM="_ZNK5clang19DependentDiagnostic16isAccessToMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic16isAccessToMemberEv")
  //</editor-fold>
  public boolean isAccessToMember() /*const*/ {
    assert (getKind() == AccessNonce.Access.getValue());
    return AccessData.IsMember;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::getAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 67,
   FQN="clang::DependentDiagnostic::getAccess", NM="_ZNK5clang19DependentDiagnostic9getAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic9getAccessEv")
  //</editor-fold>
  public AccessSpecifier getAccess() /*const*/ {
    assert (getKind() == AccessNonce.Access.getValue());
    return AccessSpecifier.valueOf(AccessData.Access);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::getAccessLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 72,
   FQN="clang::DependentDiagnostic::getAccessLoc", NM="_ZNK5clang19DependentDiagnostic12getAccessLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic12getAccessLocEv")
  //</editor-fold>
  public SourceLocation getAccessLoc() /*const*/ {
    assert (getKind() == AccessNonce.Access.getValue());
    return SourceLocation.getFromRawEncoding(AccessData.Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::getAccessTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 77,
   FQN="clang::DependentDiagnostic::getAccessTarget", NM="_ZNK5clang19DependentDiagnostic15getAccessTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic15getAccessTargetEv")
  //</editor-fold>
  public NamedDecl /*P*/ getAccessTarget() /*const*/ {
    assert (getKind() == AccessNonce.Access.getValue());
    return AccessData.TargetDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::getAccessNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 82,
   FQN="clang::DependentDiagnostic::getAccessNamingClass", NM="_ZNK5clang19DependentDiagnostic20getAccessNamingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic20getAccessNamingClassEv")
  //</editor-fold>
  public NamedDecl /*P*/ getAccessNamingClass() /*const*/ {
    assert (getKind() == AccessNonce.Access.getValue());
    return AccessData.NamingClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::getAccessBaseObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 87,
   FQN="clang::DependentDiagnostic::getAccessBaseObjectType", NM="_ZNK5clang19DependentDiagnostic23getAccessBaseObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic23getAccessBaseObjectTypeEv")
  //</editor-fold>
  public QualType getAccessBaseObjectType() /*const*/ {
    assert (getKind() == AccessNonce.Access.getValue());
    return QualType.getFromOpaquePtr(AccessData.BaseObjectType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::getDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 92,
   FQN="clang::DependentDiagnostic::getDiagnostic", NM="_ZNK5clang19DependentDiagnostic13getDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZNK5clang19DependentDiagnostic13getDiagnosticEv")
  //</editor-fold>
  public /*const*/ PartialDiagnostic /*&*/ getDiagnostic() /*const*/ {
    return Diag;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::DependentDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 97,
   FQN="clang::DependentDiagnostic::DependentDiagnostic", NM="_ZN5clang19DependentDiagnosticC1ERKNS_17PartialDiagnosticEPNS1_7StorageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnosticC1ERKNS_17PartialDiagnosticEPNS1_7StorageE")
  //</editor-fold>
  private DependentDiagnostic(final /*const*/ PartialDiagnostic /*&*/ PDiag, 
      PartialDiagnostic.Storage /*P*/ Storage) {
    // : Diag(PDiag, Storage), AccessData() 
    //START JInit
    this.Diag = new PartialDiagnostic(PDiag, Storage);
    this.AccessData = new Unnamed_struct1();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1738,
   FQN="clang::DependentDiagnostic::Create", NM="_ZN5clang19DependentDiagnostic6CreateERNS_10ASTContextEPNS_11DeclContextERKNS_17PartialDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnostic6CreateERNS_10ASTContextEPNS_11DeclContextERKNS_17PartialDiagnosticE")
  //</editor-fold>
  private static DependentDiagnostic /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ Parent, 
        final /*const*/ PartialDiagnostic /*&*/ PDiag) {
    assert (Parent.isDependentContext()) : "cannot iterate dependent diagnostics of non-dependent context";
    Parent = Parent.getPrimaryContext();
    if (!(Parent.$DeclContext$Fields().LookupPtr != null)) {
      Parent.CreateStoredDeclsMap(C);
    }
    
    DependentStoredDeclsMap /*P*/ Map = ((/*static_cast*/DependentStoredDeclsMap /*P*/ )(Parent.$DeclContext$Fields().LookupPtr));
    
    // Allocate the copy of the PartialDiagnostic via the ASTContext's
    // BumpPtrAllocator, rather than the ASTContext itself.
    PartialDiagnostic.Storage /*P*/ DiagStorage = null;
    if (PDiag.hasStorage()) {
      DiagStorage = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (C)*/ $new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
          return new PartialDiagnostic.Storage();
       });
    }
    PartialDiagnostic.Storage /*P*/ finalDiagStorage = DiagStorage;
    DependentDiagnostic /*P*/ DD = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (C)*/ $new_uint_ASTContext$C_uint(C, (type$ptr<?> New$Mem)->{
        return new DependentDiagnostic(PDiag, finalDiagStorage);
     });
    
    // TODO: Maybe we shouldn't reverse the order during insertion.
    DD.NextDiagnostic = Map.FirstDiagnostic;
    Map.FirstDiagnostic = DD;
    
    return DD;
  }

  
  /*friend  class DependentStoredDeclsMap*/
  /*friend  class DeclContext::ddiag_iterator*/
  /*friend*/protected/*private*/ DependentDiagnostic /*P*/ NextDiagnostic;
  
  private PartialDiagnostic Diag;
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 111,
   FQN="clang::DependentDiagnostic::(anonymous)", NM="_ZN5clang19DependentDiagnosticE_Unnamed_struct1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnosticE_Unnamed_struct1")
  //</editor-fold>
  private static class/*struct*/ Unnamed_struct1 {
    public /*uint*/int Loc;
    public /*JBYTE unsigned int*/ byte Access /*: 2*/;
    public /*JBIT unsigned int*/ boolean IsMember /*: 1*/;
    public NamedDecl /*P*/ TargetDecl;
    public CXXRecordDecl /*P*/ NamingClass;
    public Object/*void P*/ BaseObjectType;
    
    //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::(anonymous struct)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 111,
     FQN="clang::DependentDiagnostic::(anonymous struct)::", NM="_ZN5clang19DependentDiagnosticUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnosticUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_struct1() {
    }

    
    @Override public String toString() {
      return "" + "Loc=" + Loc // NOI18N
                + ", Access=" + $uchar2uint(Access) // NOI18N
                + ", IsMember=" + IsMember // NOI18N
                + ", TargetDecl=" + TargetDecl // NOI18N
                + ", NamingClass=" + NamingClass // NOI18N
                + ", BaseObjectType=" + BaseObjectType; // NOI18N
    }
  };
  
  private Unnamed_struct1 AccessData;
  //<editor-fold defaultstate="collapsed" desc="clang::DependentDiagnostic::~DependentDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DependentDiagnostic.h", line = 34,
   FQN="clang::DependentDiagnostic::~DependentDiagnostic", NM="_ZN5clang19DependentDiagnosticD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang19DependentDiagnosticD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  
  @Override public String toString() {
    return "" + "NextDiagnostic=" + "[DependentDiagnostic]" // NOI18N
              + ", Diag=" + "[PartialDiagnostic]" // NOI18N
              + ", AccessData=" + AccessData; // NOI18N
  }
}
