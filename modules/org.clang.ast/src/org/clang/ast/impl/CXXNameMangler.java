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

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;
import static org.clang.ast.impl.ItaniumMangleStatics.*;


/// Manage the mangling of a single name.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 214,
 FQN="(anonymous namespace)::CXXNameMangler", NM="_ZN12_GLOBAL__N_114CXXNameManglerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameManglerE")
//</editor-fold>
public class CXXNameMangler implements Destructors.ClassWithDestructor {
  private final ItaniumMangleContextImpl /*&*/ Context;
  private final raw_ostream /*&*/ Out;
  private boolean NullOut/* = false*/;
  /// In the "DisableDerivedAbiTags" mode derived ABI tags are not calculated.
  /// This mode is used when mangler creates another mangler recursively to
  /// calculate ABI tags for the function return value or the variable type.
  /// Also it is required to avoid infinite recursion in some cases.
  private boolean DisableDerivedAbiTags/* = false*/;
  
  /// The "structor" is the top-level declaration being mangled, if
  /// that's not a template specialization; otherwise it's the pattern
  /// for that specialization.
  private /*const*/ NamedDecl /*P*/ Structor;
  private /*uint*/int StructorType;
  
  /// The next substitution sequence number.
  private /*uint*/int SeqID;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 233,
   FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateE")
  //</editor-fold>
  private static class FunctionTypeDepthState {
    private /*uint*/int Bits;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 236,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::(anonymous)", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateE_Unnamed_enum")
    //</editor-fold>
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      public static final /*uint*/int InResultTypeMask = 1;
    /*}*/;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::FunctionTypeDepthState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 239,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::FunctionTypeDepthState", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateC1Ev")
    //</editor-fold>
    public FunctionTypeDepthState() {
      // : Bits(0) 
      //START JInit
      this.Bits = 0;
      //END JInit
    }

    
    /// The number of function types we're inside.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::getDepth">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 242,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::getDepth", NM="_ZNK12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState8getDepthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZNK12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState8getDepthEv")
    //</editor-fold>
    public /*uint*/int getDepth() /*const*/ {
      return Bits >>> 1;
    }

    
    /// True if we're in the return type of the innermost function type.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::isInResultType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 247,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::isInResultType", NM="_ZNK12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState14isInResultTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZNK12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState14isInResultTypeEv")
    //</editor-fold>
    public boolean isInResultType() /*const*/ {
      return ((Bits & InResultTypeMask) != 0);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::push">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 251,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::push", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState4pushEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState4pushEv")
    //</editor-fold>
    public FunctionTypeDepthState push() {
      FunctionTypeDepthState tmp = new FunctionTypeDepthState(/*Deref*/this);
      Bits = (Bits & ~InResultTypeMask) + 2;
      return tmp;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::enterResultType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 257,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::enterResultType", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState15enterResultTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState15enterResultTypeEv")
    //</editor-fold>
    public void enterResultType() {
      Bits |= InResultTypeMask;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::leaveResultType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 261,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::leaveResultType", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState15leaveResultTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState15leaveResultTypeEv")
    //</editor-fold>
    public void leaveResultType() {
      Bits &= ~InResultTypeMask;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::pop">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 265,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::pop", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState3popES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthState3popES1_")
    //</editor-fold>
    public void pop(FunctionTypeDepthState saved) {
      assert (getDepth() == saved.getDepth() + 1);
      Bits = saved.Bits;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::FunctionTypeDepthState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 233,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::FunctionTypeDepthState", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateC1ERKS1_")
    //</editor-fold>
    public /*inline*/ FunctionTypeDepthState(final /*const*/ FunctionTypeDepthState /*&*/ $Prm0) {
      // : Bits(.Bits) 
      //START JInit
      this.Bits = $Prm0.Bits;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::FunctionTypeDepthState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 233,
     FQN="(anonymous namespace)::CXXNameMangler::FunctionTypeDepthState::FunctionTypeDepthState", NM="_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22FunctionTypeDepthStateC1EOS1_")
    //</editor-fold>
    public /*inline*/ FunctionTypeDepthState(JD$Move _dparam, final FunctionTypeDepthState /*&&*/$Prm0) {
      // : Bits(static_cast<FunctionTypeDepthState &&>().Bits) 
      //START JInit
      this.Bits = $Prm0.Bits;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Bits=" + Bits; // NOI18N
    }
  };
  
  private  FunctionTypeDepthState FunctionTypeDepth;
  
  // abi_tag is a gcc attribute, taking one or more strings called "tags".
  // The goal is to annotate against which version of a library an object was
  // built and to be able to provide backwards compatibility ("dual abi").
  // For more information see docs/ItaniumMangleAbiTags.rst.
  /*typedef SmallVector<StringRef, 4> AbiTagList*/
//  public final class AbiTagList extends SmallVector<StringRef>{ };
  
  // State to gather all implicit and explicit tags used in a mangled name.
  // Must always have an instance of this while emitting any name to keep
  // track.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 281,
   FQN="(anonymous namespace)::CXXNameMangler::AbiTagState", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateE")
  //</editor-fold>
  private static final class AbiTagState implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::AbiTagState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 283,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::AbiTagState", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateC1ERPS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateC1ERPS1_")
    //</editor-fold>
    public /*explicit*/ AbiTagState(JD$Type$ref$AbiTagState$P _dparam, final type$ref<AbiTagState /*P*/ /*&*/> Head) {
      // : UsedAbiTags(), EmittedAbiTags(), LinkHead(Head), Parent(null) 
      //START JInit
      this.UsedAbiTags = new SmallVector<StringRef>(4, new StringRef());
      this.EmittedAbiTags = new SmallVector<StringRef>(4, new StringRef());
      this./*&*/LinkHead=/*&*/Head;
      /*InClass*/this.Parent = null;
      //END JInit
      Parent = LinkHead.$deref();
      LinkHead.$set(this);
    }

    
    // No copy, no move.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::AbiTagState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 289,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::AbiTagState", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateC1ERKS1_")
    //</editor-fold>
    public AbiTagState(final /*const*/ AbiTagState /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 290,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::operator=", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateaSERKS1_")
    //</editor-fold>
    public AbiTagState /*&*/ $assign(final /*const*/ AbiTagState /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::~AbiTagState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 292,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::~AbiTagState", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagStateD0Ev")
    //</editor-fold>
    public void $destroy() {
      pop();
      //START JDestroy
      EmittedAbiTags.$destroy();
      UsedAbiTags.$destroy();
      //END JDestroy
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::write">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 294,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::write", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState5writeERN4llvm11raw_ostreamEPKN5clang9NamedDeclEPKNS2_11SmallVectorINS2_9StringRefELj4EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState5writeERN4llvm11raw_ostreamEPKN5clang9NamedDeclEPKNS2_11SmallVectorINS2_9StringRefELj4EEE")
    //</editor-fold>
    public void write(final raw_ostream /*&*/ Out, /*const*/ NamedDecl /*P*/ ND, 
         /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
      ND = cast_NamedDecl(ND.getCanonicalDecl$Const());
      if (!isa_FunctionDecl(ND) && !isa_VarDecl(ND)) {
        assert (!(AdditionalAbiTags != null)) : "only function and variables need a list of additional abi tags";
        {
          /*const*/ NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(ND);
          if ((NS != null)) {
            {
              /*const*/ AbiTagAttr /*P*/ AbiTag = NS.getAttr(AbiTagAttr.class);
              if ((AbiTag != null)) {
                UsedAbiTags.insert$T$value_T(UsedAbiTags.end(), ((type$ptr<StringRef/*P*/> )AbiTag.tags().begin()), 
                    ((type$ptr<StringRef/*P*/> )AbiTag.tags().end()));
              }
            }
            // Don't emit abi tags for namespaces.
            return;
          }
        }
      }
      
      SmallVector<StringRef> TagList/*J*/= new SmallVector<StringRef>(4, new StringRef());
      {
        /*const*/ AbiTagAttr /*P*/ AbiTag = ND.getAttr(AbiTagAttr.class);
        if ((AbiTag != null)) {
          UsedAbiTags.insert$T$value_T(UsedAbiTags.end(), ((type$ptr<StringRef/*P*/> )AbiTag.tags().begin()), 
              ((type$ptr<StringRef/*P*/> )AbiTag.tags().end()));
          TagList.insert$T$value_T(TagList.end(), ((type$ptr<StringRef/*P*/> )AbiTag.tags().begin()), 
              ((type$ptr<StringRef/*P*/> )AbiTag.tags().end()));
        }
      }
      if ((AdditionalAbiTags != null)) {
        UsedAbiTags.insert$T$value_T(UsedAbiTags.end(), AdditionalAbiTags.begin$Const(), 
            AdditionalAbiTags.end$Const());
        TagList.insert$T$value_T(TagList.end(), AdditionalAbiTags.begin$Const(), 
            AdditionalAbiTags.end$Const());
      }
      
      std.sort(TagList.begin(), TagList.end());
      TagList.erase(std.unique(TagList.begin(), TagList.end(), false), TagList.end());
      
      writeSortedUniqueAbiTags(Out, TagList);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::getUsedAbiTags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 332,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::getUsedAbiTags", NM="_ZNK12_GLOBAL__N_114CXXNameMangler11AbiTagState14getUsedAbiTagsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZNK12_GLOBAL__N_114CXXNameMangler11AbiTagState14getUsedAbiTagsEv")
    //</editor-fold>
    public /*const*/SmallVector<StringRef> /*&*/ getUsedAbiTags() /*const*/ {
      return UsedAbiTags;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::setUsedAbiTags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 333,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::setUsedAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState14setUsedAbiTagsERKN4llvm11SmallVectorINS2_9StringRefELj4EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState14setUsedAbiTagsERKN4llvm11SmallVectorINS2_9StringRefELj4EEE")
    //</editor-fold>
    public void setUsedAbiTags(final /*const*/SmallVector<StringRef> /*&*/ AbiTags) {
      UsedAbiTags.$assign(AbiTags);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::getEmittedAbiTags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 337,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::getEmittedAbiTags", NM="_ZNK12_GLOBAL__N_114CXXNameMangler11AbiTagState17getEmittedAbiTagsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZNK12_GLOBAL__N_114CXXNameMangler11AbiTagState17getEmittedAbiTagsEv")
    //</editor-fold>
    public /*const*/SmallVector<StringRef> /*&*/ getEmittedAbiTags() /*const*/ {
      return EmittedAbiTags;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::getSortedUniqueUsedAbiTags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 341,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::getSortedUniqueUsedAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState26getSortedUniqueUsedAbiTagsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState26getSortedUniqueUsedAbiTagsEv")
    //</editor-fold>
    public /*const*/SmallVector<StringRef> /*&*/ getSortedUniqueUsedAbiTags() {
      std.sort(UsedAbiTags.begin(), UsedAbiTags.end());
      UsedAbiTags.erase(std.unique(UsedAbiTags.begin(), UsedAbiTags.end(), false), 
          UsedAbiTags.end());
      return UsedAbiTags;
    }

  /*private:*/
    //! All abi tags used implicitly or explicitly.
    private SmallVector<StringRef> UsedAbiTags;
    //! All explicit abi tags (i.e. not from namespace).
    private SmallVector<StringRef> EmittedAbiTags;
    
    private final type$ref<AbiTagState /*P*/ /*&*/> LinkHead;
    private AbiTagState /*P*/ Parent/* = null*/;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::pop">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 357,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::pop", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState3popEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState3popEv")
    //</editor-fold>
    private void pop() {
      assert (LinkHead.$deref() == this) : "abi tag link head must point to us on destruction";
      if ((Parent != null)) {
        Parent.UsedAbiTags.insert$T$value_T(Parent.UsedAbiTags.end(), 
            UsedAbiTags.begin(), UsedAbiTags.end());
        Parent.EmittedAbiTags.insert$T$value_T(Parent.EmittedAbiTags.end(), 
            EmittedAbiTags.begin(), 
            EmittedAbiTags.end());
      }
      LinkHead.$set(Parent);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::AbiTagState::writeSortedUniqueAbiTags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 370,
     FQN="(anonymous namespace)::CXXNameMangler::AbiTagState::writeSortedUniqueAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState24writeSortedUniqueAbiTagsERN4llvm11raw_ostreamERKNS2_11SmallVectorINS2_9StringRefELj4EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11AbiTagState24writeSortedUniqueAbiTagsERN4llvm11raw_ostreamERKNS2_11SmallVectorINS2_9StringRefELj4EEE")
    //</editor-fold>
    private void writeSortedUniqueAbiTags(final raw_ostream /*&*/ Out, final /*const*/SmallVector<StringRef> /*&*/ AbiTags) {
      for (final /*const*/ StringRef /*&*/ Tag : AbiTags) {
        EmittedAbiTags.push_back(Tag);
        Out.$out(/*KEEP_STR*/$B);
        Out.$out_uint(Tag.size());
        Out.$out(/*NO_COPY*/Tag);
      }
    }

    
    @Override public String toString() {
      return "" + "UsedAbiTags=" + UsedAbiTags // NOI18N
                + ", EmittedAbiTags=" + EmittedAbiTags // NOI18N
                + ", LinkHead=" + LinkHead // NOI18N
                + ", Parent=" + Parent; // NOI18N
    }
  };
  
  private type$ptr<AbiTagState> AbiTags/* = null*/;
  private AbiTagState AbiTagsRoot;
  
  private DenseMapTypeInt<Object/*uintptr_t*/> Substitutions;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 385,
   FQN="(anonymous namespace)::CXXNameMangler::getASTContext", NM="_ZNK12_GLOBAL__N_114CXXNameMangler13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZNK12_GLOBAL__N_114CXXNameMangler13getASTContextEv")
  //</editor-fold>
  private ASTContext /*&*/ getASTContext() /*const*/ {
    return Context.getASTContext();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::CXXNameMangler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 388,
   FQN="(anonymous namespace)::CXXNameMangler::CXXNameMangler", NM="_ZN12_GLOBAL__N_114CXXNameManglerC1ERNS_24ItaniumMangleContextImplERN4llvm11raw_ostreamEPKN5clang9NamedDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameManglerC1ERNS_24ItaniumMangleContextImplERN4llvm11raw_ostreamEPKN5clang9NamedDeclEb")
  //</editor-fold>
  public CXXNameMangler(final ItaniumMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_) {
    this(C, Out_, 
      (/*const*/ NamedDecl /*P*/ )null, false);
  }
  public CXXNameMangler(final ItaniumMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_, 
      /*const*/ NamedDecl /*P*/ D/*= null*/) {
    this(C, Out_, 
      D, false);
  }
  public CXXNameMangler(final ItaniumMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_, 
      /*const*/ NamedDecl /*P*/ D/*= null*/, boolean NullOut_/*= false*/) {
    // : Context(C), Out(Out_), NullOut(NullOut_), DisableDerivedAbiTags(false), Structor(getStructor(D)), StructorType(0), SeqID(0), FunctionTypeDepth(), AbiTags(null), AbiTagsRoot(AbiTags), Substitutions() 
    //START JInit
    this./*&*/Context=/*&*/C;
    this./*&*/Out=/*&*/Out_;
    this.NullOut = NullOut_;
    /*InClass*/this.DisableDerivedAbiTags = false;
    this.Structor = getStructor(D);
    this.StructorType = 0;
    this.SeqID = 0;
    this.FunctionTypeDepth = new  FunctionTypeDepthState();
    /*InClass*/this.AbiTags = create_type$null$ptr();
    this.AbiTagsRoot = new AbiTagState(JD$Type$ref$AbiTagState$P.INSTANCE, AbiTags.star$ref());
    this.Substitutions = new DenseMapTypeInt<Object/*uintptr_t*/>(DenseMapInfoVoid$Ptr.$Info(), 0);
    //END JInit
    // These can't be mangled without a ctor type or dtor type.
    assert (!(D != null) || (!isa_CXXDestructorDecl(D) && !isa_CXXConstructorDecl(D)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::CXXNameMangler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 396,
   FQN="(anonymous namespace)::CXXNameMangler::CXXNameMangler", NM="_ZN12_GLOBAL__N_114CXXNameManglerC1ERNS_24ItaniumMangleContextImplERN4llvm11raw_ostreamEPKN5clang18CXXConstructorDeclENS6_11CXXCtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameManglerC1ERNS_24ItaniumMangleContextImplERN4llvm11raw_ostreamEPKN5clang18CXXConstructorDeclENS6_11CXXCtorTypeE")
  //</editor-fold>
  public CXXNameMangler(JD$ItaniumMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType _dparam, final ItaniumMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_, 
      /*const*/ CXXConstructorDecl /*P*/ D, CXXCtorType Type) {
    // : Context(C), Out(Out_), NullOut(false), DisableDerivedAbiTags(false), Structor(getStructor(D)), StructorType(Type), SeqID(0), FunctionTypeDepth(), AbiTags(null), AbiTagsRoot(AbiTags), Substitutions() 
    //START JInit
    this./*&*/Context=/*&*/C;
    this./*&*/Out=/*&*/Out_;
    /*InClass*/this.NullOut = false;
    /*InClass*/this.DisableDerivedAbiTags = false;
    this.Structor = getStructor(D);
    this.StructorType = Type.getValue();
    this.SeqID = 0;
    this.FunctionTypeDepth = new  FunctionTypeDepthState();
    /*InClass*/this.AbiTags = create_type$null$ptr();
    this.AbiTagsRoot = new AbiTagState(JD$Type$ref$AbiTagState$P.INSTANCE, AbiTags.star$ref());
    this.Substitutions = new DenseMapTypeInt<Object/*uintptr_t*/>(DenseMapInfoVoid$Ptr.$Info(), 0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::CXXNameMangler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 400,
   FQN="(anonymous namespace)::CXXNameMangler::CXXNameMangler", NM="_ZN12_GLOBAL__N_114CXXNameManglerC1ERNS_24ItaniumMangleContextImplERN4llvm11raw_ostreamEPKN5clang17CXXDestructorDeclENS6_11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameManglerC1ERNS_24ItaniumMangleContextImplERN4llvm11raw_ostreamEPKN5clang17CXXDestructorDeclENS6_11CXXDtorTypeE")
  //</editor-fold>
  public CXXNameMangler(JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType _dparam, final ItaniumMangleContextImpl /*&*/ C, final raw_ostream /*&*/ Out_, 
      /*const*/ CXXDestructorDecl /*P*/ D, CXXDtorType Type) {
    // : Context(C), Out(Out_), NullOut(false), DisableDerivedAbiTags(false), Structor(getStructor(D)), StructorType(Type), SeqID(0), FunctionTypeDepth(), AbiTags(null), AbiTagsRoot(AbiTags), Substitutions() 
    //START JInit
    this./*&*/Context=/*&*/C;
    this./*&*/Out=/*&*/Out_;
    /*InClass*/this.NullOut = false;
    /*InClass*/this.DisableDerivedAbiTags = false;
    this.Structor = getStructor(D);
    this.StructorType = Type.getValue();
    this.SeqID = 0;
    this.FunctionTypeDepth = new  FunctionTypeDepthState();
    /*InClass*/this.AbiTags = create_type$null$ptr();;
    this.AbiTagsRoot = new AbiTagState(JD$Type$ref$AbiTagState$P.INSTANCE, AbiTags.star$ref());
    this.Substitutions = new DenseMapTypeInt<Object/*uintptr_t*/>(DenseMapInfoVoid$Ptr.$Info(), 0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::CXXNameMangler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 405,
   FQN="(anonymous namespace)::CXXNameMangler::CXXNameMangler", NM="_ZN12_GLOBAL__N_114CXXNameManglerC1ERS0_RN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameManglerC1ERS0_RN4llvm11raw_ostreamE")
  //</editor-fold>
  public CXXNameMangler(final CXXNameMangler /*&*/ Outer, final raw_ostream /*&*/ Out_) {
    // : Context(Outer.Context), Out(Out_), NullOut(false), DisableDerivedAbiTags(false), Structor(Outer.Structor), StructorType(Outer.StructorType), SeqID(Outer.SeqID), FunctionTypeDepth(), AbiTags(null), AbiTagsRoot(AbiTags), Substitutions() 
    //START JInit
    this./*&*/Context=/*&*/Outer.Context;
    this./*&*/Out=/*&*/Out_;
    this.NullOut = false;
    /*InClass*/this.DisableDerivedAbiTags = false;
    this.Structor = Outer.Structor;
    this.StructorType = Outer.StructorType;
    this.SeqID = Outer.SeqID;
    this.FunctionTypeDepth = new  FunctionTypeDepthState();
    /*InClass*/this.AbiTags = create_type$null$ptr();;
    this.AbiTagsRoot = new AbiTagState(JD$Type$ref$AbiTagState$P.INSTANCE, AbiTags.star$ref());
    this.Substitutions = new DenseMapTypeInt<Object/*uintptr_t*/>(DenseMapInfoVoid$Ptr.$Info(), 0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::CXXNameMangler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 410,
   FQN="(anonymous namespace)::CXXNameMangler::CXXNameMangler", NM="_ZN12_GLOBAL__N_114CXXNameManglerC1ERS0_RN4llvm16raw_null_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameManglerC1ERS0_RN4llvm16raw_null_ostreamE")
  //</editor-fold>
  public CXXNameMangler(final CXXNameMangler /*&*/ Outer, final raw_null_ostream /*&*/ Out_) {
    // : Context(Outer.Context), Out(Out_), NullOut(true), DisableDerivedAbiTags(false), Structor(Outer.Structor), StructorType(Outer.StructorType), SeqID(Outer.SeqID), FunctionTypeDepth(), AbiTags(null), AbiTagsRoot(AbiTags), Substitutions() 
    //START JInit
    this./*&*/Context=/*&*/Outer.Context;
    this./*&*/Out=/*&*/Out_;
    this.NullOut = true;
    /*InClass*/this.DisableDerivedAbiTags = false;
    this.Structor = Outer.Structor;
    this.StructorType = Outer.StructorType;
    this.SeqID = Outer.SeqID;
    this.FunctionTypeDepth = new  FunctionTypeDepthState();
    /*InClass*/this.AbiTags = create_type$null$ptr();;
    this.AbiTagsRoot = new AbiTagState(JD$Type$ref$AbiTagState$P.INSTANCE, AbiTags.star$ref());
    this.Substitutions = new DenseMapTypeInt<Object/*uintptr_t*/>(DenseMapInfoVoid$Ptr.$Info(), 0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::getStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 426,
   FQN="(anonymous namespace)::CXXNameMangler::getStream", NM="_ZN12_GLOBAL__N_114CXXNameMangler9getStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler9getStreamEv")
  //</editor-fold>
  public raw_ostream /*&*/ getStream() {
    return Out;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::disableDerivedAbiTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 428,
   FQN="(anonymous namespace)::CXXNameMangler::disableDerivedAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler21disableDerivedAbiTagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler21disableDerivedAbiTagsEv")
  //</editor-fold>
  public void disableDerivedAbiTags() {
    DisableDerivedAbiTags = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::shouldHaveAbiTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4443,
   FQN="(anonymous namespace)::CXXNameMangler::shouldHaveAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler17shouldHaveAbiTagsERNS_24ItaniumMangleContextImplEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler17shouldHaveAbiTagsERNS_24ItaniumMangleContextImplEPKN5clang7VarDeclE")
  //</editor-fold>
  public static boolean shouldHaveAbiTags(final ItaniumMangleContextImpl /*&*/ C, 
                   /*const*/ VarDecl /*P*/ VD) {
    raw_null_ostream NullOutStream = null;
    CXXNameMangler TrackAbiTags = null;
    try {
      NullOutStream/*J*/= new raw_null_ostream();
      TrackAbiTags/*J*/= new CXXNameMangler(C, NullOutStream, (/*const*/ NamedDecl /*P*/ )null, true);
      TrackAbiTags.mangle(VD);
      return (TrackAbiTags.AbiTagsRoot.getUsedAbiTags().size() != 0);
    } finally {
      if (TrackAbiTags != null) { TrackAbiTags.$destroy(); }
      if (NullOutStream != null) { NullOutStream.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 628,
   FQN="(anonymous namespace)::CXXNameMangler::mangle", NM="_ZN12_GLOBAL__N_114CXXNameMangler6mangleEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler6mangleEPKN5clang9NamedDeclE")
  //</editor-fold>
  public void mangle(/*const*/ NamedDecl /*P*/ D) {
    // <mangled-name> ::= _Z <encoding>
    //            ::= <data name>
    //            ::= <special-name>
    Out.$out(/*KEEP_STR*/"_Z");
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        mangleFunctionEncoding(FD);
      } else {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          mangleName(VD);
        } else {
          /*const*/ IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(D);
          if ((IFD != null)) {
            mangleName(IFD.getAnonField());
          } else {
            mangleName(cast_FieldDecl(D));
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleCallOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1007,
   FQN="(anonymous namespace)::CXXNameMangler::mangleCallOffset", NM="_ZN12_GLOBAL__N_114CXXNameMangler16mangleCallOffsetExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler16mangleCallOffsetExx")
  //</editor-fold>
  public void mangleCallOffset(long/*int64_t*/ NonVirtual, long/*int64_t*/ Virtual) {
    //  <call-offset>  ::= h <nv-offset> _
    //                 ::= v <v-offset> _
    //  <nv-offset>    ::= <offset number>        # non-virtual base override
    //  <v-offset>     ::= <offset number> _ <virtual offset number>
    //                      # virtual base override, with vcall offset
    if (!(Virtual != 0)) {
      Out.$out_char($$h);
      mangleNumber(NonVirtual);
      Out.$out_char($$UNDERSCORE);
      return;
    }
    
    Out.$out_char($$v);
    mangleNumber(NonVirtual);
    Out.$out_char($$UNDERSCORE);
    mangleNumber(Virtual);
    Out.$out_char($$UNDERSCORE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 988,
   FQN="(anonymous namespace)::CXXNameMangler::mangleNumber", NM="_ZN12_GLOBAL__N_114CXXNameMangler12mangleNumberERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler12mangleNumberERKN4llvm6APSIntE")
  //</editor-fold>
  public void mangleNumber(final /*const*/ APSInt /*&*/ Value) {
    if (Value.isSigned() && Value.isNegative()) {
      Out.$out_char($$n);
      Value.abs().print(Out, /*signed*/ false);
    } else {
      Value.print(Out, /*signed*/ false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 997,
   FQN="(anonymous namespace)::CXXNameMangler::mangleNumber", NM="_ZN12_GLOBAL__N_114CXXNameMangler12mangleNumberEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler12mangleNumberEx")
  //</editor-fold>
  public void mangleNumber(long/*int64_t*/ Number) {
    //  <number> ::= [n] <non-negative decimal integer>
    if (Number < 0) {
      Out.$out_char($$n);
      Number = -Number;
    }
    
    Out.$out_llong(Number);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleFloat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 945,
   FQN="(anonymous namespace)::CXXNameMangler::mangleFloat", NM="_ZN12_GLOBAL__N_114CXXNameMangler11mangleFloatERKN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11mangleFloatERKN4llvm7APFloatE")
  //</editor-fold>
  public void mangleFloat(final /*const*/ APFloat /*&*/ f) {
    // ABI:
    //   Floating-point literals are encoded using a fixed-length
    //   lowercase hexadecimal string corresponding to the internal
    //   representation (IEEE on Itanium), high-order bytes first,
    //   without leading zeroes. For example: "Lf bf800000 E" is -1.0f
    //   on Itanium.
    // The 'without leading zeroes' thing seems to be an editorial
    // mistake; see the discussion on cxx-abi-dev beginning on
    // 2012-01-16.
    
    // Our requirements here are just barely weird enough to justify
    // using a custom algorithm instead of post-processing APInt::toString().
    APInt valueBits = f.bitcastToAPInt();
    /*uint*/int numCharacters = $div_uint((valueBits.getBitWidth() + 3), 4);
    assert (numCharacters != 0);
    
    // Allocate a buffer of the right number of characters.
    SmallString buffer/*J*/= new SmallString(20, numCharacters);
    
    // Fill the buffer left-to-right.
    for (/*uint*/int stringIndex = 0; stringIndex != numCharacters; ++stringIndex) {
      // The bit-index of the next hex digit.
      /*uint*/int digitBitIndex = 4 * (numCharacters - stringIndex - 1);
      
      // Project out 4 bits starting at 'digitIndex'.
      long/*uint64_t*/ hexDigit = valueBits.getRawData().$at($div_uint(digitBitIndex, llvm.integerPartWidth));
      hexDigit >>>= ($rem_uint(digitBitIndex, llvm.integerPartWidth));
      hexDigit &= $int2ullong(0xF);
      
      // Map that over to a lowercase hex digit.
      final/*static*/ /*const*//*char*/byte charForHex[/*16*/] = mangleFloat$$.charForHex;
      buffer.$set(stringIndex, charForHex[(int)hexDigit]);
    }
    
    Out.write(buffer.data(), numCharacters);
  }
  private static final class mangleFloat$$ {
    static final/*static*/ /*const*//*char*/byte charForHex[/*16*/] = new$char(16, 
      $$0, $$1, $$2, $$3, $$4, $$5, $$6, $$7, 
      $$8, $$9, $$a, $$b, $$c, $$d, $$e, $$f
    );
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleFunctionEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 643,
   FQN="(anonymous namespace)::CXXNameMangler::mangleFunctionEncoding", NM="_ZN12_GLOBAL__N_114CXXNameMangler22mangleFunctionEncodingEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22mangleFunctionEncodingEPKN5clang12FunctionDeclE")
  //</editor-fold>
  public void mangleFunctionEncoding(/*const*/ FunctionDecl /*P*/ FD) {
    raw_svector_ostream FunctionEncodingStream = null;
    CXXNameMangler FunctionEncodingMangler = null;
    try {
      // <encoding> ::= <function name> <bare-function-type>
      
      // Don't mangle in the type if this isn't a decl we should typically mangle.
      if (!Context.shouldMangleDeclName(FD)) {
        mangleName(FD);
        return;
      }
      
      SmallVector<StringRef> ReturnTypeAbiTags = makeFunctionReturnTypeTags(FD);
      if (ReturnTypeAbiTags.empty()) {
        // There are no tags for return type, the simplest case.
        mangleName(FD);
        mangleFunctionEncodingBareType(FD);
        return;
      }
      
      // Mangle function name and encoding to temporary buffer.
      // We have to output name and encoding to the same mangler to get the same
      // substitution as it will be in final mangling.
      SmallString/*256*/ FunctionEncodingBuf/*J*/= new SmallString/*256*/(256);
      FunctionEncodingStream/*J*/= new raw_svector_ostream(FunctionEncodingBuf);
      FunctionEncodingMangler/*J*/= new CXXNameMangler(/*Deref*/this, FunctionEncodingStream);
      // Output name of the function.
      FunctionEncodingMangler.disableDerivedAbiTags();
      FunctionEncodingMangler.mangleNameWithAbiTags(FD, (/*const*/SmallVector<StringRef> /*P*/)null);
      
      // Remember length of the function name in the buffer.
      /*size_t*/int EncodingPositionStart = FunctionEncodingStream.str().size();
      FunctionEncodingMangler.mangleFunctionEncodingBareType(FD);
      
      // Get tags from return type that are not present in function name or
      // encoding.
      final /*const*/SmallVector<StringRef> /*&*/ UsedAbiTags = FunctionEncodingMangler.AbiTagsRoot.getSortedUniqueUsedAbiTags();
      SmallVector<StringRef> AdditionalAbiTags/*J*/= new SmallVector<StringRef>(JD$UInt_T$C$R.INSTANCE, 4, ReturnTypeAbiTags.size(), new StringRef());
      AdditionalAbiTags.erase(std.set_difference(ReturnTypeAbiTags.begin(), ReturnTypeAbiTags.end(), 
              UsedAbiTags.begin$Const(), UsedAbiTags.end$Const(), 
              AdditionalAbiTags.begin()), 
          AdditionalAbiTags.end());
      
      // Output name with implicit tags and function encoding from temporary buffer.
      mangleNameWithAbiTags(FD, $AddrOf(AdditionalAbiTags));
      Out.$out(FunctionEncodingStream.str().substr(EncodingPositionStart));
    } finally {
      if (FunctionEncodingMangler != null) { FunctionEncodingMangler.$destroy(); }
      if (FunctionEncodingStream != null) { FunctionEncodingStream.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleSeqID">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4175,
   FQN="(anonymous namespace)::CXXNameMangler::mangleSeqID", NM="_ZN12_GLOBAL__N_114CXXNameMangler11mangleSeqIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler11mangleSeqIDEj")
  //</editor-fold>
  public void mangleSeqID(/*uint*/int SeqID) {
    if (SeqID == 1) {
      Out.$out_char($$0);
    } else if ($greater_uint(SeqID, 1)) {
      SeqID--;
      
      // <seq-id> is encoded in base-36, using digits and upper case letters.
      /*char*/byte Buffer[/*7*/] = new$char(7); // log(2**32) / log(36) ~= 7
      MutableArrayRefChar BufferRef/*J*/= new MutableArrayRefChar(Buffer);
      std.reverse_iteratorChar I = BufferRef.rbegin();
      
      for (; SeqID != 0; SeqID = $div_uint(SeqID, 36)) {
        /*uint*/int C = $rem_uint(SeqID, 36);
        I.$postInc(0).star$ref().$set($uint2char(($less_uint(C, 10) ? $char2uint($$0) + C : $char2uint($$A) + C - 10)));
      }
      
      Out.write(I.base(), $sub_reverse_iterator$C(I, BufferRef.rbegin()));
    }
    Out.$out_char($$UNDERSCORE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 800,
   FQN="(anonymous namespace)::CXXNameMangler::mangleName", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  public void mangleName(/*const*/ NamedDecl /*P*/ ND) {
    {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(ND);
      if ((VD != null)) {
        raw_null_ostream NullOutStream = null;
        CXXNameMangler VariableNameMangler = null;
        try {
          // Variables should have implicit tags from its type.
          SmallVector<StringRef> VariableTypeAbiTags = makeVariableTypeTags(VD);
          if (VariableTypeAbiTags.empty()) {
            // Simple case no variable type tags.
            mangleNameWithAbiTags(VD, (/*const*/SmallVector<StringRef> /*P*/)null);
            return;
          }
          
          // Mangle variable name to null stream to collect tags.
          NullOutStream/*J*/= new raw_null_ostream();
          VariableNameMangler/*J*/= new CXXNameMangler(/*Deref*/this, NullOutStream);
          VariableNameMangler.disableDerivedAbiTags();
          VariableNameMangler.mangleNameWithAbiTags(VD, (/*const*/SmallVector<StringRef> /*P*/)null);
          
          // Get tags from variable type that are not present in its name.
          final /*const*/SmallVector<StringRef> /*&*/ UsedAbiTags = VariableNameMangler.AbiTagsRoot.getSortedUniqueUsedAbiTags();
          SmallVector<StringRef> AdditionalAbiTags/*J*/= new SmallVector<StringRef>(JD$UInt_T$C$R.INSTANCE, 4, VariableTypeAbiTags.size(), new StringRef());
          AdditionalAbiTags.erase(std.set_difference(VariableTypeAbiTags.begin(), 
                  VariableTypeAbiTags.end(), UsedAbiTags.begin$Const(), 
                  UsedAbiTags.end$Const(), AdditionalAbiTags.begin()), 
              AdditionalAbiTags.end());
          
          // Output name with implicit tags.
          mangleNameWithAbiTags(VD, $AddrOf(AdditionalAbiTags));
        } finally {
          if (VariableNameMangler != null) { VariableNameMangler.$destroy(); }
          if (NullOutStream != null) { NullOutStream.$destroy(); }
        }
      } else {
        mangleNameWithAbiTags(ND, (/*const*/SmallVector<StringRef> /*P*/)null);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2193,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEN5clang8QualTypeE")
  //</editor-fold>
  public void mangleType(QualType T) {
    // If our type is instantiation-dependent but not dependent, we mangle
    // it as it was written in the source, removing any top-level sugar. 
    // Otherwise, use the canonical type.
    //
    // FIXME: This is an approximation of the instantiation-dependent name 
    // mangling rules, since we should really be using the type as written and
    // augmented via semantic analysis (i.e., with implicit conversions and
    // default template arguments) for any instantiation-dependent type. 
    // Unfortunately, that requires several changes to our AST:
    //   - Instantiation-dependent TemplateSpecializationTypes will need to be 
    //     uniqued, so that we can handle substitutions properly
    //   - Default template arguments will need to be represented in the
    //     TemplateSpecializationType, since they need to be mangled even though
    //     they aren't written.
    //   - Conversions on non-type template arguments need to be expressed, since
    //     they can affect the mangling of sizeof/alignof.
    if (!T.$arrow().isInstantiationDependentType() || T.$arrow().isDependentType()) {
      T.$assignMove(T.getCanonicalType());
    } else {
      // Desugar any types that are purely sugar.
      do {
        {
          // Don't desugar through template specialization types that aren't
          // type aliases. We need to mangle the template arguments as written.
          /*const*/ TemplateSpecializationType /*P*/ TST = dyn_cast_TemplateSpecializationType(T);
          if ((TST != null)) {
            if (!TST.isTypeAlias()) {
              break;
            }
          }
        }
        
        QualType Desugared = T.getSingleStepDesugaredType(Context.getASTContext());
        if ($eq_QualType$C(Desugared, T)) {
          break;
        }
        
        T.$assign(Desugared);
      } while (true);
    }
    SplitQualType split = T.split();
    Qualifiers quals = new Qualifiers(split.Quals);
    /*const*/ Type /*P*/ ty = split.Ty;
    
    boolean isSubstitutable = isTypeSubstitutable(new Qualifiers(quals), ty);
    if (isSubstitutable && mangleSubstitution(new QualType(T))) {
      return;
    }
    
    // If we're mangling a qualified array type, push the qualifiers to
    // the element type.
    if (quals.$bool() && isa_ArrayType(T)) {
      ty = Context.getASTContext().getAsArrayType(new QualType(T));
      quals.$assignMove(new Qualifiers());
      // Note that we don't update T: we want to add the
      // substitution at the original type.
    }
    if (quals.$bool()) {
      mangleQualifiers(new Qualifiers(quals));
      // Recurse:  even if the qualified type isn't yet substitutable,
      // the unqualified type might be.
      mangleType(new QualType(ty, 0));
    } else {
      switch (ty.getTypeClass()) {
       case Builtin:
        mangleType(((/*static_cast*//*const*/ BuiltinType /*P*/ )(ty)));
        break;
       case Complex:
        mangleType(((/*static_cast*//*const*/ ComplexType /*P*/ )(ty)));
        break;
       case Pointer:
        mangleType(((/*static_cast*//*const*/ PointerType /*P*/ )(ty)));
        break;
       case BlockPointer:
        mangleType(((/*static_cast*//*const*/ BlockPointerType /*P*/ )(ty)));
        break;
       case LValueReference:
        mangleType(((/*static_cast*//*const*/ LValueReferenceType /*P*/ )(ty)));
        break;
       case RValueReference:
        mangleType(((/*static_cast*//*const*/ RValueReferenceType /*P*/ )(ty)));
        break;
       case MemberPointer:
        mangleType(((/*static_cast*//*const*/ MemberPointerType /*P*/ )(ty)));
        break;
       case ConstantArray:
        mangleType(((/*static_cast*//*const*/ ConstantArrayType /*P*/ )(ty)));
        break;
       case IncompleteArray:
        mangleType(((/*static_cast*//*const*/ IncompleteArrayType /*P*/ )(ty)));
        break;
       case VariableArray:
        mangleType(((/*static_cast*//*const*/ VariableArrayType /*P*/ )(ty)));
        break;
       case DependentSizedArray:
        mangleType(((/*static_cast*//*const*/ DependentSizedArrayType /*P*/ )(ty)));
        break;
       case DependentSizedExtVector:
        mangleType(((/*static_cast*//*const*/ DependentSizedExtVectorType /*P*/ )(ty)));
        break;
       case Vector:
        mangleType(((/*static_cast*//*const*/ VectorType /*P*/ )(ty)));
        break;
       case ExtVector:
        mangleType(((/*static_cast*//*const*/ ExtVectorType /*P*/ )(ty)));
        break;
       case FunctionProto:
        mangleType(((/*static_cast*//*const*/ FunctionProtoType /*P*/ )(ty)));
        break;
       case FunctionNoProto:
        mangleType(((/*static_cast*//*const*/ FunctionNoProtoType /*P*/ )(ty)));
        break;
       case UnresolvedUsing:
        mangleType(((/*static_cast*//*const*/ UnresolvedUsingType /*P*/ )(ty)));
        break;
       case Paren:
        throw new llvm_unreachable("can't mangle non-canonical type ParenType");
//        return;
       case Typedef:
        throw new llvm_unreachable("can't mangle non-canonical type TypedefType");
//        return;
       case Adjusted:
        throw new llvm_unreachable("can't mangle non-canonical type AdjustedType");
//        return;
       case Decayed:
        throw new llvm_unreachable("can't mangle non-canonical type DecayedType");
//        return;
       case TypeOfExpr:
        mangleType(((/*static_cast*//*const*/ TypeOfExprType /*P*/ )(ty)));
        break;
       case TypeOf:
        mangleType(((/*static_cast*//*const*/ TypeOfType /*P*/ )(ty)));
        break;
       case Decltype:
        mangleType(((/*static_cast*//*const*/ DecltypeType /*P*/ )(ty)));
        break;
       case UnaryTransform:
        mangleType(((/*static_cast*//*const*/ UnaryTransformType /*P*/ )(ty)));
        break;
       case Record:
        mangleType(((/*static_cast*//*const*/ RecordType /*P*/ )(ty)));
        break;
       case Enum:
        mangleType(((/*static_cast*//*const*/ EnumType /*P*/ )(ty)));
        break;
       case Elaborated:
        throw new llvm_unreachable("can't mangle non-canonical type ElaboratedType");
//        return;
       case Attributed:
        throw new llvm_unreachable("can't mangle non-canonical type AttributedType");
//        return;
       case TemplateTypeParm:
        mangleType(((/*static_cast*//*const*/ TemplateTypeParmType /*P*/ )(ty)));
        break;
       case SubstTemplateTypeParm:
        throw new llvm_unreachable("can't mangle non-canonical type SubstTemplateTypeParmType");
//        return;
       case SubstTemplateTypeParmPack:
        mangleType(((/*static_cast*//*const*/ SubstTemplateTypeParmPackType /*P*/ )(ty)));
        break;
       case TemplateSpecialization:
        mangleType(((/*static_cast*//*const*/ TemplateSpecializationType /*P*/ )(ty)));
        break;
       case Auto:
        mangleType(((/*static_cast*//*const*/ AutoType /*P*/ )(ty)));
        break;
       case InjectedClassName:
        mangleType(((/*static_cast*//*const*/ InjectedClassNameType /*P*/ )(ty)));
        break;
       case DependentName:
        mangleType(((/*static_cast*//*const*/ DependentNameType /*P*/ )(ty)));
        break;
       case DependentTemplateSpecialization:
        mangleType(((/*static_cast*//*const*/ DependentTemplateSpecializationType /*P*/ )(ty)));
        break;
       case PackExpansion:
        mangleType(((/*static_cast*//*const*/ PackExpansionType /*P*/ )(ty)));
        break;
       case ObjCObject:
        mangleType(((/*static_cast*//*const*/ ObjCObjectType /*P*/ )(ty)));
        break;
       case ObjCInterface:
        mangleType(((/*static_cast*//*const*/ ObjCInterfaceType /*P*/ )(ty)));
        break;
       case ObjCObjectPointer:
        mangleType(((/*static_cast*//*const*/ ObjCObjectPointerType /*P*/ )(ty)));
        break;
       case Pipe:
        mangleType(((/*static_cast*//*const*/ PipeType /*P*/ )(ty)));
        break;
       case Atomic:
        mangleType(((/*static_cast*//*const*/ AtomicType /*P*/ )(ty)));
        break;
      }
    }
    
    // Add the substitution.
    if (isSubstitutable) {
      addSubstitution(new QualType(T));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleNameOrStandardSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2273,
   FQN="(anonymous namespace)::CXXNameMangler::mangleNameOrStandardSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler32mangleNameOrStandardSubstitutionEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler32mangleNameOrStandardSubstitutionEPKN5clang9NamedDeclE")
  //</editor-fold>
  public void mangleNameOrStandardSubstitution(/*const*/ NamedDecl /*P*/ ND) {
    if (!mangleStandardSubstitution(ND)) {
      mangleName(ND);
    }
  }

/*private:*/
  
  
  // <substitution> ::= S <seq-id> _
  //                ::= S_
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4204,
   FQN="(anonymous namespace)::CXXNameMangler::mangleSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEPKN5clang9NamedDeclE")
  //</editor-fold>
  private boolean mangleSubstitution(/*const*/ NamedDecl /*P*/ ND) {
    // Try one of the standard substitutions first.
    if (mangleStandardSubstitution(ND)) {
      return true;
    }
    
    ND = cast_NamedDecl(ND.getCanonicalDecl$Const());
    return mangleSubstitution(reinterpret_cast_Object/*uintptr_t*/(ND));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4220,
   FQN="(anonymous namespace)::CXXNameMangler::mangleSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEN5clang8QualTypeE")
  //</editor-fold>
  private boolean mangleSubstitution(QualType T) {
    if (!hasMangledSubstitutionQualifiers(new QualType(T))) {
      {
        /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
        if ((RT != null)) {
          return mangleSubstitution(RT.getDecl());
        }
      }
    }
    
    Object/*uintptr_t*/ TypePtr = reinterpret_cast_Object/*uintptr_t*/(T.getAsOpaquePtr());
    
    return mangleSubstitution(TypePtr);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4231,
   FQN="(anonymous namespace)::CXXNameMangler::mangleSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEN5clang12TemplateNameE")
  //</editor-fold>
  private boolean mangleSubstitution(TemplateName Template) {
    {
      TemplateDecl /*P*/ TD = Template.getAsTemplateDecl();
      if ((TD != null)) {
        return mangleSubstitution(TD);
      }
    }
    
    Template.$assignMove(Context.getASTContext().getCanonicalTemplateName(new TemplateName(Template)));
    return mangleSubstitution(reinterpret_cast_Object/*uintptr_t*/(Template.getAsVoidPointer()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleSubstitution">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4240,
   FQN="(anonymous namespace)::CXXNameMangler::mangleSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleSubstitutionEj")
  //</editor-fold>
  private boolean mangleSubstitution(Object/*uintptr_t*/ Ptr) {    
    DenseMapIteratorTypeInt<Object> I = Substitutions.find(Ptr);
    if (I.$eq(/*NO_ITER_COPY*/Substitutions.end())) {
      return false;
    }
    
    /*uint*/int SeqID = I.$arrow().second;
    Out.$out_char($$S);
    mangleSeqID(SeqID);
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleExistingSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4196,
   FQN="(anonymous namespace)::CXXNameMangler::mangleExistingSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler26mangleExistingSubstitutionEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler26mangleExistingSubstitutionEN5clang12TemplateNameE")
  //</editor-fold>
  private void mangleExistingSubstitution(TemplateName tname) {
    boolean result = mangleSubstitution(new TemplateName(tname));
    assert (result) : "no existing substitution for template name";
    ///*J:(void)*/result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleStandardSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4307,
   FQN="(anonymous namespace)::CXXNameMangler::mangleStandardSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler26mangleStandardSubstitutionEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler26mangleStandardSubstitutionEPKN5clang9NamedDeclE")
  //</editor-fold>
  private boolean mangleStandardSubstitution(/*const*/ NamedDecl /*P*/ ND) {
    {
      // <substitution> ::= St # ::std::
      /*const*/ NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(ND);
      if ((NS != null)) {
        if (isStd(NS)) {
          Out.$out(/*KEEP_STR*/"St");
          return true;
        }
      }
    }
    {
      
      /*const*/ ClassTemplateDecl /*P*/ TD = dyn_cast_ClassTemplateDecl(ND);
      if ((TD != null)) {
        if (!isStdNamespace(getEffectiveDeclContext(TD))) {
          return false;
        }
        
        // <substitution> ::= Sa # ::std::allocator
        if (TD.getIdentifier().isStr(/*KEEP_STR*/"allocator")) {
          Out.$out(/*KEEP_STR*/"Sa");
          return true;
        }
        
        // <<substitution> ::= Sb # ::std::basic_string
        if (TD.getIdentifier().isStr(/*KEEP_STR*/"basic_string")) {
          Out.$out(/*KEEP_STR*/"Sb");
          return true;
        }
      }
    }
    {
      
      /*const*/ ClassTemplateSpecializationDecl /*P*/ SD = dyn_cast_ClassTemplateSpecializationDecl(ND);
      if ((SD != null)) {
        if (!isStdNamespace(getEffectiveDeclContext(SD))) {
          return false;
        }
        
        //    <substitution> ::= Ss # ::std::basic_string<char,
        //                            ::std::char_traits<char>,
        //                            ::std::allocator<char> >
        if (SD.getIdentifier().isStr(/*KEEP_STR*/"basic_string")) {
          final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = SD.getTemplateArgs();
          if (TemplateArgs.size() != 3) {
            return false;
          }
          if (!isCharType(TemplateArgs.$at(0).getAsType())) {
            return false;
          }
          if (!isCharSpecialization(TemplateArgs.$at(1).getAsType(), $("char_traits"))) {
            return false;
          }
          if (!isCharSpecialization(TemplateArgs.$at(2).getAsType(), $("allocator"))) {
            return false;
          }
          
          Out.$out(/*KEEP_STR*/"Ss");
          return true;
        }
        
        //    <substitution> ::= Si # ::std::basic_istream<char,
        //                            ::std::char_traits<char> >
        if (isStreamCharSpecialization(SD, /*KEEP_STR*/"basic_istream")) {
          Out.$out(/*KEEP_STR*/"Si");
          return true;
        }
        
        //    <substitution> ::= So # ::std::basic_ostream<char,
        //                            ::std::char_traits<char> >
        if (isStreamCharSpecialization(SD, /*KEEP_STR*/"basic_ostream")) {
          Out.$out(/*KEEP_STR*/"So");
          return true;
        }
        
        //    <substitution> ::= Sd # ::std::basic_iostream<char,
        //                            ::std::char_traits<char> >
        if (isStreamCharSpecialization(SD, /*KEEP_STR*/"basic_iostream")) {
          Out.$out(/*KEEP_STR*/"Sd");
          return true;
        }
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::addSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 453,
   FQN="(anonymous namespace)::CXXNameMangler::addSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEPKN5clang9NamedDeclE")
  //</editor-fold>
  private void addSubstitution(/*const*/ NamedDecl /*P*/ ND) {
    ND = cast_NamedDecl(ND.getCanonicalDecl$Const());
    
    addSubstitution(reinterpret_cast_Object/*uintptr_t*/(ND));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::addSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4384,
   FQN="(anonymous namespace)::CXXNameMangler::addSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEN5clang8QualTypeE")
  //</editor-fold>
  private void addSubstitution(QualType T) {
    if (!hasMangledSubstitutionQualifiers(new QualType(T))) {
      {
        /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
        if ((RT != null)) {
          addSubstitution(RT.getDecl());
          return;
        }
      }
    }
    
    Object/*uintptr_t*/ TypePtr = reinterpret_cast_Object/*uintptr_t*/(T.getAsOpaquePtr());
    addSubstitution(TypePtr);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::addSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4396,
   FQN="(anonymous namespace)::CXXNameMangler::addSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEN5clang12TemplateNameE")
  //</editor-fold>
  private void addSubstitution(TemplateName Template) {
    {
      TemplateDecl /*P*/ TD = Template.getAsTemplateDecl();
      if ((TD != null)) {
        addSubstitution(TD);
        /*JAVA:return*/return;
      }
    }
    
    Template.$assignMove(Context.getASTContext().getCanonicalTemplateName(new TemplateName(Template)));
    addSubstitution(reinterpret_cast_Object/*uintptr_t*/(Template.getAsVoidPointer()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::addSubstitution">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4404,
   FQN="(anonymous namespace)::CXXNameMangler::addSubstitution", NM="_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler15addSubstitutionEj")
  //</editor-fold>
  private void addSubstitution(Object/*uintptr_t*/ Ptr) {
    assert (!(Substitutions.count(Ptr) != 0)) : "Substitution already exists!";
    Substitutions.$set(Ptr, SeqID++);
  }

  
  
  /// Mangle everything prior to the base-unresolved-name in an unresolved-name.
  ///
  /// \param recursive - true if this is being called recursively,
  ///   i.e. if there is more prefix "to the right".
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnresolvedPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1062,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnresolvedPrefix", NM="_ZN12_GLOBAL__N_114CXXNameMangler22mangleUnresolvedPrefixEPN5clang19NestedNameSpecifierEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22mangleUnresolvedPrefixEPN5clang19NestedNameSpecifierEb")
  //</editor-fold>
  private void mangleUnresolvedPrefix(NestedNameSpecifier /*P*/ qualifier) {
    mangleUnresolvedPrefix(qualifier, 
                        false);
  }
  private void mangleUnresolvedPrefix(NestedNameSpecifier /*P*/ qualifier, 
                        boolean recursive/*= false*/) {
    
    // x, ::x
    // <unresolved-name> ::= [gs] <base-unresolved-name>
    
    // T::x / decltype(p)::x
    // <unresolved-name> ::= sr <unresolved-type> <base-unresolved-name>
    
    // T::N::x /decltype(p)::N::x
    // <unresolved-name> ::= srN <unresolved-type> <unresolved-qualifier-level>+ E
    //                       <base-unresolved-name>
    
    // A::x, N::y, A<T>::z; "gs" means leading "::"
    // <unresolved-name> ::= [gs] sr <unresolved-qualifier-level>+ E
    //                       <base-unresolved-name>
    switch (qualifier.getKind()) {
     case Global:
      Out.$out(/*KEEP_STR*/"gs");
      
      // We want an 'sr' unless this is the entire NNS.
      if (recursive) {
        Out.$out(/*KEEP_STR*/"sr");
      }
      
      // We never want an 'E' here.
      return;
     case Super:
      throw new llvm_unreachable("Can't mangle __super specifier");
     case Namespace:
      if ((qualifier.getPrefix() != null)) {
        mangleUnresolvedPrefix(qualifier.getPrefix(), 
            /*recursive*/ true);
      } else {
        Out.$out(/*KEEP_STR*/"sr");
      }
      mangleSourceNameWithAbiTags(qualifier.getAsNamespace());
      break;
     case NamespaceAlias:
      if ((qualifier.getPrefix() != null)) {
        mangleUnresolvedPrefix(qualifier.getPrefix(), 
            /*recursive*/ true);
      } else {
        Out.$out(/*KEEP_STR*/"sr");
      }
      mangleSourceNameWithAbiTags(qualifier.getAsNamespaceAlias());
      break;
     case TypeSpec:
     case TypeSpecWithTemplate:
      {
        /*const*/ Type /*P*/ type = qualifier.getAsType();
        
        // We only want to use an unresolved-type encoding if this is one of:
        //   - a decltype
        //   - a template type parameter
        //   - a template template parameter with arguments
        // In all of these cases, we should have no prefix.
        if ((qualifier.getPrefix() != null)) {
          mangleUnresolvedPrefix(qualifier.getPrefix(), 
              /*recursive*/ true);
        } else {
          // Otherwise, all the cases want this.
          Out.$out(/*KEEP_STR*/"sr");
        }
        if (mangleUnresolvedTypeOrSimpleId(new QualType(type, 0), new StringRef(recursive ? $N : $EMPTY))) {
          return;
        }
        
        break;
      }
     case Identifier:
      // Member expressions can have these without prefixes.
      if ((qualifier.getPrefix() != null)) {
        mangleUnresolvedPrefix(qualifier.getPrefix(), 
            /*recursive*/ true);
      } else {
        Out.$out(/*KEEP_STR*/"sr");
      }
      
      mangleSourceName(qualifier.getAsIdentifier());
      // An Identifier has no type information, so we can't emit abi tags for it.
      break;
    }
    
    // If this was the innermost part of the NNS, and we fell out to
    // here, append an 'E'.
    if (!recursive) {
      Out.$out_char($$E);
    }
  }

  
  /// Mangle an unresolved-name, which is generally used for names which
  /// weren't resolved to specific entities.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnresolvedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1154,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnresolvedName", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleUnresolvedNameEPN5clang19NestedNameSpecifierENS1_15DeclarationNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleUnresolvedNameEPN5clang19NestedNameSpecifierENS1_15DeclarationNameEj")
  //</editor-fold>
  private void mangleUnresolvedName(NestedNameSpecifier /*P*/ qualifier, 
                      DeclarationName name) {
    mangleUnresolvedName(qualifier, 
                      name, 
                      UnknownArity);
  }
  private void mangleUnresolvedName(NestedNameSpecifier /*P*/ qualifier, 
                      DeclarationName name, 
                      /*uint*/int knownArity/*= UnknownArity*/) {
    if ((qualifier != null)) {
      mangleUnresolvedPrefix(qualifier);
    }
    switch (name.getNameKind()) {
     case Identifier:
      // <base-unresolved-name> ::= <simple-id>
      mangleSourceName(name.getAsIdentifierInfo());
      break;
     case CXXDestructorName:
      // <base-unresolved-name> ::= dn <destructor-name>
      Out.$out(/*KEEP_STR*/"dn");
      mangleUnresolvedTypeOrSimpleId(name.getCXXNameType());
      break;
     case CXXConversionFunctionName:
     case CXXLiteralOperatorName:
     case CXXOperatorName:
      // <base-unresolved-name> ::= on <operator-name>
      Out.$out(/*KEEP_STR*/"on");
      mangleOperatorName(new DeclarationName(name), knownArity);
      break;
     case CXXConstructorName:
      throw new llvm_unreachable("Can't mangle a constructor name!");
     case CXXUsingDirective:
      throw new llvm_unreachable("Can't mangle a using directive name!");
     case ObjCMultiArgSelector:
     case ObjCOneArgSelector:
     case ObjCZeroArgSelector:
      throw new llvm_unreachable("Can't mangle Objective-C selector names here!");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleFunctionEncodingBareType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 690,
   FQN="(anonymous namespace)::CXXNameMangler::mangleFunctionEncodingBareType", NM="_ZN12_GLOBAL__N_114CXXNameMangler30mangleFunctionEncodingBareTypeEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler30mangleFunctionEncodingBareTypeEPKN5clang12FunctionDeclE")
  //</editor-fold>
  private void mangleFunctionEncodingBareType(/*const*/ FunctionDecl /*P*/ FD) {
    if (FD.hasAttr(EnableIfAttr.class)) {
      FunctionTypeDepthState Saved = FunctionTypeDepth.push();
      Out.$out(/*KEEP_STR*/"Ua9enable_ifI");
      // FIXME: specific_attr_iterator iterates in reverse order. Fix that and use
      // it here.
      for (std.reverse_iterator<Attr /*P*/ /*const*/> I = FD.getAttrs$Const().rbegin$Const(), 
          E = FD.getAttrs$Const().rend$Const();
           $noteq_reverse_iterator$C(I, E); I.$preInc()) {
        EnableIfAttr /*P*/ EIA = dyn_cast_EnableIfAttr(I.$star());
        if (!(EIA != null)) {
          continue;
        }
        Out.$out_char($$X);
        mangleExpression(EIA.getCond());
        Out.$out_char($$E);
      }
      Out.$out_char($$E);
      FunctionTypeDepth.pop(new FunctionTypeDepthState(Saved));
    }
    {
      
      // When mangling an inheriting constructor, the bare function type used is
      // that of the inherited constructor.
      /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(FD);
      if ((CD != null)) {
        {
          InheritedConstructor Inherited = CD.getInheritedConstructor();
          if (Inherited.$bool()) {
            FD = Inherited.getConstructor();
          }
        }
      }
    }
    
    // Whether the mangling of a function type includes the return type depends on
    // the context and the nature of the function. The rules for deciding whether
    // the return type is included are:
    //
    //   1. Template functions (names or types) have return types encoded, with
    //   the exceptions listed below.
    //   2. Function types not appearing as part of a function name mangling,
    //   e.g. parameters, pointer types, etc., have return type encoded, with the
    //   exceptions listed below.
    //   3. Non-template function names do not have return types encoded.
    //
    // The exceptions mentioned in (1) and (2) above, for which the return type is
    // never included, are
    //   1. Constructors.
    //   2. Destructors.
    //   3. Conversion operator functions, e.g. operator int.
    boolean MangleReturnType = false;
    {
      FunctionTemplateDecl /*P*/ PrimaryTemplate = FD.getPrimaryTemplate();
      if ((PrimaryTemplate != null)) {
        if (!(isa_CXXConstructorDecl(FD) || isa_CXXDestructorDecl(FD)
           || isa_CXXConversionDecl(FD))) {
          MangleReturnType = true;
        }
        
        // Mangle the type of the primary template.
        FD = PrimaryTemplate.getTemplatedDecl();
      }
    }
    
    mangleBareFunctionType(FD.getType().$arrow().castAs(FunctionProtoType.class), 
        MangleReturnType, FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleNameWithAbiTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 833,
   FQN="(anonymous namespace)::CXXNameMangler::mangleNameWithAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler21mangleNameWithAbiTagsEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler21mangleNameWithAbiTagsEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleNameWithAbiTags(/*const*/ NamedDecl /*P*/ ND, 
                       /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    //  <name> ::= <nested-name>
    //         ::= <unscoped-name>
    //         ::= <unscoped-template-name> <template-args>
    //         ::= <local-name>
    //
    /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(ND);
    
    // If this is an extern variable declared locally, the relevant DeclContext
    // is that of the containing namespace, or the translation unit.
    // FIXME: This is a hack; extern variables declared locally should have
    // a proper semantic declaration context!
    if (isLocalContainerContext(DC) && ND.hasLinkage() && !isLambda(ND)) {
      while (!DC.isNamespace() && !DC.isTranslationUnit()) {
        DC = getEffectiveParentContext(DC);
      }
    } else if ((GetLocalClassDecl(ND) != null)) {
      mangleLocalName(ND, AdditionalAbiTags);
      return;
    }
    
    DC = IgnoreLinkageSpecDecls(DC);
    if (DC.isTranslationUnit() || isStdNamespace(DC)) {
      // Check if we have a template.
      type$ref</*const*/ TemplateArgumentList /*P*/ > TemplateArgs = create_type$null$ref(null);
      {
        /*const*/ TemplateDecl /*P*/ TD = isTemplate(ND, TemplateArgs);
        if ((TD != null)) {
          mangleUnscopedTemplateName(TD, AdditionalAbiTags);
          mangleTemplateArgs($Deref(TemplateArgs.$deref()));
          return;
        }
      }
      
      mangleUnscopedName(ND, AdditionalAbiTags);
      return;
    }
    if (isLocalContainerContext(DC)) {
      mangleLocalName(ND, AdditionalAbiTags);
      return;
    }
    
    mangleNestedName(ND, DC, AdditionalAbiTags);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 877,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplateName", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateNameEPKN5clang12TemplateDeclEPKNS1_16TemplateArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateNameEPKN5clang12TemplateDeclEPKNS1_16TemplateArgumentEj")
  //</editor-fold>
  private void mangleTemplateName(/*const*/ TemplateDecl /*P*/ TD, 
                    /*const*/type$ptr<TemplateArgument/*P*/> TemplateArgs, 
                    /*uint*/int NumTemplateArgs) {
    /*const*/ DeclContext /*P*/ DC = IgnoreLinkageSpecDecls(getEffectiveDeclContext(TD));
    if (DC.isTranslationUnit() || isStdNamespace(DC)) {
      mangleUnscopedTemplateName(TD, (/*const*/SmallVector<StringRef> /*P*/)null);
      mangleTemplateArgs(TemplateArgs, NumTemplateArgs);
    } else {
      mangleNestedName(TD, TemplateArgs, NumTemplateArgs);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnqualifiedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 475,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnqualifiedName", NM="_ZN12_GLOBAL__N_114CXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleUnqualifiedName(/*const*/ NamedDecl /*P*/ ND, 
                       /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    mangleUnqualifiedName(ND, ND.getDeclName(), UnknownArity, 
        AdditionalAbiTags);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnqualifiedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1186,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnqualifiedName", NM="_ZN12_GLOBAL__N_114CXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclENS1_15DeclarationNameEjPKN4llvm11SmallVectorINS6_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler21mangleUnqualifiedNameEPKN5clang9NamedDeclENS1_15DeclarationNameEjPKN4llvm11SmallVectorINS6_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleUnqualifiedName(/*const*/ NamedDecl /*P*/ ND, 
                       DeclarationName Name, 
                       /*uint*/int KnownArity, 
                       /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    /*uint*/int Arity = KnownArity;
    //  <unqualified-name> ::= <operator-name>
    //                     ::= <ctor-dtor-name>
    //                     ::= <source-name>
    switch (Name.getNameKind()) {
     case Identifier:
      {
        {
          /*const*/ IdentifierInfo /*P*/ II = Name.getAsIdentifierInfo();
          if ((II != null)) {
            // We must avoid conflicts between internally- and externally-
            // linked variable and function declaration names in the same TU:
            //   void test() { extern void foo(); }
            //   static void foo();
            // This naming convention is the same as that followed by GCC,
            // though it shouldn't actually matter.
            if ((ND != null) && ND.getFormalLinkage() == Linkage.InternalLinkage
               && getEffectiveDeclContext(ND).isFileContext()) {
              Out.$out_char($$L);
            }
            
            mangleSourceName(II);
            writeAbiTags(ND, AdditionalAbiTags);
            break;
          }
        }
        
        // Otherwise, an anonymous entity.  We must have a declaration.
        assert ((ND != null)) : "mangling empty name without declaration";
        {
          
          /*const*/ NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(ND);
          if ((NS != null)) {
            if (NS.isAnonymousNamespace()) {
              // This is how gcc mangles these names.
              Out.$out(/*KEEP_STR*/"12_GLOBAL__N_1");
              break;
            }
          }
        }
        {
          
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(ND);
          if ((VD != null)) {
            // We must have an anonymous union or struct declaration.
            /*const*/ RecordDecl /*P*/ RD = cast_RecordDecl(VD.getType().$arrow().getAs$RecordType().getDecl());
            
            // Itanium C++ ABI 5.1.2:
            //
            //   For the purposes of mangling, the name of an anonymous union is
            //   considered to be the name of the first named data member found by a
            //   pre-order, depth-first, declaration-order walk of the data members of
            //   the anonymous union. If there is no such data member (i.e., if all of
            //   the data members in the union are unnamed), then there is no way for
            //   a program to refer to the anonymous union, and there is therefore no
            //   need to mangle its name.
            assert (RD.isAnonymousStructOrUnion()) : "Expected anonymous struct or union!";
            /*const*/ FieldDecl /*P*/ FD = RD.findFirstNamedDataMember();
            
            // It's actually possible for various reasons for us to get here
            // with an empty anonymous struct / union.  Fortunately, it
            // doesn't really matter what name we generate.
            if (!(FD != null)) {
              break;
            }
            assert ((FD.getIdentifier() != null)) : "Data member name isn't an identifier!";
            
            mangleSourceName(FD.getIdentifier());
            // Not emitting abi tags: internal name anyway.
            break;
          }
        }
        
        // Class extensions have no name as a category, and it's possible
        // for them to be the semantic parent of certain declarations
        // (primarily, tag decls defined within declarations).  Such
        // declarations will always have internal linkage, so the name
        // doesn't really matter, but we shouldn't crash on them.  For
        // safety, just handle all ObjC containers here.
        if (isa_ObjCContainerDecl(ND)) {
          break;
        }
        
        // We must have an anonymous struct.
        /*const*/ TagDecl /*P*/ TD = cast_TagDecl(ND);
        {
          /*const*/ TypedefNameDecl /*P*/ D = TD.getTypedefNameForAnonDecl();
          if ((D != null)) {
            assert (TD.getDeclContext$Const() == D.getDeclContext$Const()) : "Typedef should not be in another decl context!";
            assert ((D.getDeclName().getAsIdentifierInfo() != null)) : "Typedef was not named!";
            mangleSourceName(D.getDeclName().getAsIdentifierInfo());
            assert (!(AdditionalAbiTags != null)) : "Type cannot have additional abi tags";
            // Explicit abi tags are still possible; take from underlying type, not
            // from typedef.
            writeAbiTags(TD, (/*const*/SmallVector<StringRef> /*P*/)null);
            break;
          }
        }
        {
          
          // <unnamed-type-name> ::= <closure-type-name>
          // 
          // <closure-type-name> ::= Ul <lambda-sig> E [ <nonnegative number> ] _
          // <lambda-sig> ::= <parameter-type>+   # Parameter types or 'v' for 'void'.
          /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(TD);
          if ((Record != null)) {
            if (Record.isLambda() && (Record.getLambdaManglingNumber() != 0)) {
              assert (!(AdditionalAbiTags != null)) : "Lambda type cannot have additional abi tags";
              mangleLambda(Record);
              break;
            }
          }
        }
        if (TD.isExternallyVisible()) {
          /*uint*/int UnnamedMangle = getASTContext().getManglingNumber(TD);
          Out.$out(/*KEEP_STR*/"Ut");
          if ($greater_uint(UnnamedMangle, 1)) {
            Out.$out_uint(UnnamedMangle - 2);
          }
          Out.$out_char($$UNDERSCORE);
          writeAbiTags(TD, AdditionalAbiTags);
          break;
        }
        
        // Get a unique id for the anonymous struct. If it is not a real output
        // ID doesn't matter so use fake one.
        /*uint*/int AnonStructId = $ullong2uint(NullOut ? $int2ullong(0) : Context.getAnonymousStructId(TD));
        
        // Mangle it as a source name in the form
        // [n] $_<id>
        // where n is the length of the string.
        SmallString/*8*/ Str/*J*/= new SmallString/*8*/(8);
        Str.$addassign(/*STRINGREF_STR*/"$_");
        Str.$addassign(new StringRef(llvm.utostr($uint2ulong(AnonStructId))));
        
        Out.$out_uint(Str.size());
        Out.$out(Str);
        break;
      }
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      throw new llvm_unreachable("Can't mangle Objective-C selector names here!");
     case CXXConstructorName:
      {
        /*const*/ CXXRecordDecl /*P*/ InheritedFrom = null;
        /*const*/ TemplateArgumentList /*P*/ InheritedTemplateArgs = null;
        {
          InheritedConstructor Inherited = cast_CXXConstructorDecl(ND).getInheritedConstructor();
          if (Inherited.$bool()) {
            InheritedFrom = Inherited.getConstructor().getParent();
            InheritedTemplateArgs
               = Inherited.getConstructor().getTemplateSpecializationArgs();
          }
        }
        if (ND == Structor) {
          // If the named decl is the C++ constructor we're mangling, use the type
          // we were given.
          mangleCXXCtorType(/*static_cast*/CXXCtorType.valueOf(StructorType), InheritedFrom);
        } else {
          // Otherwise, use the complete constructor name. This is relevant if a
          // class with a constructor is declared within a constructor.
          mangleCXXCtorType(CXXCtorType.Ctor_Complete, InheritedFrom);
        }
        
        // FIXME: The template arguments are part of the enclosing prefix or
        // nested-name, but it's more convenient to mangle them here.
        if ((InheritedTemplateArgs != null)) {
          mangleTemplateArgs($Deref(InheritedTemplateArgs));
        }
        
        writeAbiTags(ND, AdditionalAbiTags);
        break;
      }
     case CXXDestructorName:
      if (ND == Structor) {
        // If the named decl is the C++ destructor we're mangling, use the type we
        // were given.
        mangleCXXDtorType(/*static_cast*/CXXDtorType.valueOf(StructorType));
      } else {
        // Otherwise, use the complete destructor name. This is relevant if a
        // class with a destructor is declared within a destructor.
        mangleCXXDtorType(CXXDtorType.Dtor_Complete);
      }
      writeAbiTags(ND, AdditionalAbiTags);
      break;
     case CXXOperatorName:
      if ((ND != null) && Arity == UnknownArity) {
        Arity = cast_FunctionDecl(ND).getNumParams();
        {
          
          // If we have a member function, we need to include the 'this' pointer.
          /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(ND);
          if ((MD != null)) {
            if (!MD.isStatic()) {
              Arity++;
            }
          }
        }
      }
     case CXXConversionFunctionName:
     case CXXLiteralOperatorName:
      // FALLTHROUGH
      mangleOperatorName(new DeclarationName(Name), Arity);
      writeAbiTags(ND, AdditionalAbiTags);
      break;
     case CXXUsingDirective:
      throw new llvm_unreachable("Can't mangle a using directive name!");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnscopedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 890,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnscopedName", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleUnscopedNameEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleUnscopedNameEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleUnscopedName(/*const*/ NamedDecl /*P*/ ND, 
                    /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    //  <unscoped-name> ::= <unqualified-name>
    //                  ::= St <unqualified-name>   # ::std::
    if (isStdNamespace(IgnoreLinkageSpecDecls(getEffectiveDeclContext(ND)))) {
      Out.$out(/*KEEP_STR*/"St");
    }
    
    mangleUnqualifiedName(ND, AdditionalAbiTags);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnscopedTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 901,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnscopedTemplateName", NM="_ZN12_GLOBAL__N_114CXXNameMangler26mangleUnscopedTemplateNameEPKN5clang12TemplateDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler26mangleUnscopedTemplateNameEPKN5clang12TemplateDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleUnscopedTemplateName(/*const*/ TemplateDecl /*P*/ ND, /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    //     <unscoped-template-name> ::= <unscoped-name>
    //                              ::= <substitution>
    if (mangleSubstitution(ND)) {
      return;
    }
    {
      
      // <template-template-param> ::= <template-param>
      /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(ND);
      if ((TTP != null)) {
        assert (!(AdditionalAbiTags != null)) : "template template param cannot have abi tags";
        mangleTemplateParameter(TTP.getIndex());
      } else if (isa_BuiltinTemplateDecl(ND)) {
        mangleUnscopedName(ND, AdditionalAbiTags);
      } else {
        mangleUnscopedName(ND.getTemplatedDecl(), AdditionalAbiTags);
      }
    }
    
    addSubstitution(ND);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnscopedTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 922,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnscopedTemplateName", NM="_ZN12_GLOBAL__N_114CXXNameMangler26mangleUnscopedTemplateNameEN5clang12TemplateNameEPKN4llvm11SmallVectorINS3_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler26mangleUnscopedTemplateNameEN5clang12TemplateNameEPKN4llvm11SmallVectorINS3_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleUnscopedTemplateName(TemplateName Template, /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    {
      //     <unscoped-template-name> ::= <unscoped-name>
      //                              ::= <substitution>
      TemplateDecl /*P*/ TD = Template.getAsTemplateDecl();
      if ((TD != null)) {
        mangleUnscopedTemplateName(TD, AdditionalAbiTags);
        /*JAVA:return*/return;
      }
    }
    if (mangleSubstitution(new TemplateName(Template))) {
      return;
    }
    assert (!(AdditionalAbiTags != null)) : "dependent template name cannot have abi tags";
    
    DependentTemplateName /*P*/ Dependent = Template.getAsDependentTemplateName();
    assert ((Dependent != null)) : "Not a dependent template name?";
    {
      /*const*/ IdentifierInfo /*P*/ Id = Dependent.getIdentifier();
      if ((Id != null)) {
        mangleSourceName(Id);
      } else {
        mangleOperatorName(Dependent.getOperator(), UnknownArity);
      }
    }
    
    addSubstitution(new TemplateName(Template));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleSourceName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1381,
   FQN="(anonymous namespace)::CXXNameMangler::mangleSourceName", NM="_ZN12_GLOBAL__N_114CXXNameMangler16mangleSourceNameEPKN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler16mangleSourceNameEPKN5clang14IdentifierInfoE")
  //</editor-fold>
  private void mangleSourceName(/*const*/ IdentifierInfo /*P*/ II) {
    // <source-name> ::= <positive length number> <identifier>
    // <number> ::= [n] <non-negative decimal integer>
    // <identifier> ::= <unqualified source code identifier>
    Out.$out_uint(II.getLength()).$out(II.getName());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleSourceNameWithAbiTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 622,
   FQN="(anonymous namespace)::CXXNameMangler::mangleSourceNameWithAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler27mangleSourceNameWithAbiTagsEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler27mangleSourceNameWithAbiTagsEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleSourceNameWithAbiTags(/*const*/ NamedDecl /*P*/ ND) {
    mangleSourceNameWithAbiTags(ND, (/*const*/SmallVector<StringRef> /*P*/)null);
  }
  private void mangleSourceNameWithAbiTags(/*const*/ NamedDecl /*P*/ ND, /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags/*= null*/) {
    mangleSourceName(ND.getIdentifier());
    writeAbiTags(ND, AdditionalAbiTags);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleLocalName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1434,
   FQN="(anonymous namespace)::CXXNameMangler::mangleLocalName", NM="_ZN12_GLOBAL__N_114CXXNameMangler15mangleLocalNameEPKN5clang4DeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler15mangleLocalNameEPKN5clang4DeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE")
  //</editor-fold>
  private void mangleLocalName(/*const*/ Decl /*P*/ D, 
                 /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    // <local-name> := Z <function encoding> E <entity name> [<discriminator>]
    //              := Z <function encoding> E s [<discriminator>]
    // <local-name> := Z <function encoding> E d [ <parameter number> ] 
    //                 _ <entity name>
    // <discriminator> := _ <non-negative number>
    assert (isa_NamedDecl(D) || isa_BlockDecl(D));
    /*const*/ RecordDecl /*P*/ RD = GetLocalClassDecl(D);
    /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext((RD != null) ? RD : D);
    
    Out.$out_char($$Z);
    {
      AbiTagState LocalAbiTags = null;
      try {
        LocalAbiTags/*J*/= new AbiTagState(JD$Type$ref$AbiTagState$P.INSTANCE, AbiTags.star$ref());
        {
          
          /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(DC);
          if ((MD != null)) {
            mangleObjCMethodName(MD);
          } else {
            /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(DC);
            if ((BD != null)) {
              mangleBlockForPrefix(BD);
            } else {
              mangleFunctionEncoding(cast_FunctionDecl(DC));
            }
          }
        }
        
        // Implicit ABI tags (from namespace) are not available in the following
        // entity; reset to actually emitted tags, which are available.
        LocalAbiTags.setUsedAbiTags(LocalAbiTags.getEmittedAbiTags());
      } finally {
        if (LocalAbiTags != null) { LocalAbiTags.$destroy(); }
      }
    }
    
    Out.$out_char($$E);
    
    // GCC 5.3.0 doesn't emit derived ABI tags for local names but that seems to
    // be a bug that is fixed in trunk.
    if ((RD != null)) {
      // The parameter number is omitted for the last parameter, 0 for the 
      // second-to-last parameter, 1 for the third-to-last parameter, etc. The 
      // <entity name> will of course contain a <closure-type-name>: Its 
      // numbering will be local to the particular argument in which it appears
      // -- other default arguments do not affect its encoding.
      /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
      if (CXXRD.isLambda()) {
        {
          /*const*/ ParmVarDecl /*P*/ Parm = dyn_cast_or_null_ParmVarDecl(CXXRD.getLambdaContextDecl());
          if ((Parm != null)) {
            {
              /*const*/ FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(Parm.getDeclContext$Const());
              if ((Func != null)) {
                Out.$out_char($$d);
                /*uint*/int Num = Func.getNumParams() - Parm.getFunctionScopeIndex();
                if ($greater_uint(Num, 1)) {
                  mangleNumber($uint2long(Num - 2));
                }
                Out.$out_char($$UNDERSCORE);
              }
            }
          }
        }
      }
      
      // Mangle the name relative to the closest enclosing function.
      // equality ok because RD derived from ND above
      if (D == RD) {
        mangleUnqualifiedName(RD, AdditionalAbiTags);
      } else {
        /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
        if ((BD != null)) {
          manglePrefix(getEffectiveDeclContext(BD), true/*NoFunction*/);
          assert (!(AdditionalAbiTags != null)) : "Block cannot have additional abi tags";
          mangleUnqualifiedBlock(BD);
        } else {
          /*const*/ NamedDecl /*P*/ ND = cast_NamedDecl(D);
          mangleNestedName(ND, getEffectiveDeclContext(ND), AdditionalAbiTags, 
              true/*NoFunction*/);
        }
      }
    } else {
      /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
      if ((BD != null)) {
        {
          // Mangle a block in a default parameter; see above explanation for
          // lambdas.
          /*const*/ ParmVarDecl /*P*/ Parm = dyn_cast_or_null_ParmVarDecl(BD.getBlockManglingContextDecl());
          if ((Parm != null)) {
            {
              /*const*/ FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(Parm.getDeclContext$Const());
              if ((Func != null)) {
                Out.$out_char($$d);
                /*uint*/int Num = Func.getNumParams() - Parm.getFunctionScopeIndex();
                if ($greater_uint(Num, 1)) {
                  mangleNumber($uint2long(Num - 2));
                }
                Out.$out_char($$UNDERSCORE);
              }
            }
          }
        }
        assert (!(AdditionalAbiTags != null)) : "Block cannot have additional abi tags";
        mangleUnqualifiedBlock(BD);
      } else {
        mangleUnqualifiedName(cast_NamedDecl(D), AdditionalAbiTags);
      }
    }
    {
      
      /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl((RD != null) ? RD : D);
      if ((ND != null)) {
        uint$ref disc = create_uint$ref();
        if (Context.getNextDiscriminator(ND, disc)) {
          if ($less_uint(disc.$deref(), 10)) {
            Out.$out_char($$UNDERSCORE).$out_uint(disc.$deref());
          } else {
            Out.$out(/*KEEP_STR*/"__").$out_uint(disc.$deref()).$out_char($$UNDERSCORE);
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleBlockForPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1533,
   FQN="(anonymous namespace)::CXXNameMangler::mangleBlockForPrefix", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleBlockForPrefixEPKN5clang9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleBlockForPrefixEPKN5clang9BlockDeclE")
  //</editor-fold>
  private void mangleBlockForPrefix(/*const*/ BlockDecl /*P*/ Block) {
    if ((GetLocalClassDecl(Block) != null)) {
      mangleLocalName(Block, /* AdditionalAbiTags */ (/*const*/SmallVector<StringRef> /*P*/)null);
      return;
    }
    /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(Block);
    if (isLocalContainerContext(DC)) {
      mangleLocalName(Block, /* AdditionalAbiTags */ (/*const*/SmallVector<StringRef> /*P*/)null);
      return;
    }
    manglePrefix(getEffectiveDeclContext(Block));
    mangleUnqualifiedBlock(Block);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnqualifiedBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1547,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnqualifiedBlock", NM="_ZN12_GLOBAL__N_114CXXNameMangler22mangleUnqualifiedBlockEPKN5clang9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22mangleUnqualifiedBlockEPKN5clang9BlockDeclE")
  //</editor-fold>
  private void mangleUnqualifiedBlock(/*const*/ BlockDecl /*P*/ Block) {
    {
      Decl /*P*/ Context = Block.getBlockManglingContextDecl();
      if ((Context != null)) {
        if ((isa_VarDecl(Context) || isa_FieldDecl(Context))
           && Context.getDeclContext().isRecord()) {
          /*const*/ NamedDecl /*P*/ ND = cast_NamedDecl(Context);
          if ((ND.getIdentifier() != null)) {
            mangleSourceNameWithAbiTags(ND);
            Out.$out_char($$M);
          }
        }
      }
    }
    
    // If we have a block mangling number, use it.
    /*uint*/int Number = Block.getBlockManglingNumber();
    // Otherwise, just make up a number. It doesn't matter what it is because
    // the symbol in question isn't externally visible.
    if (!(Number != 0)) {
      Number = Context.getBlockId(Block, false);
    }
    Out.$out(/*KEEP_STR*/"Ub");
    if ($greater_uint(Number, 0)) {
      Out.$out_uint(Number - 1);
    }
    Out.$out_char($$UNDERSCORE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1571,
   FQN="(anonymous namespace)::CXXNameMangler::mangleLambda", NM="_ZN12_GLOBAL__N_114CXXNameMangler12mangleLambdaEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler12mangleLambdaEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  private void mangleLambda(/*const*/ CXXRecordDecl /*P*/ Lambda) {
    {
      // If the context of a closure type is an initializer for a class member 
      // (static or nonstatic), it is encoded in a qualified name with a final 
      // <prefix> of the form:
      //
      //   <data-member-prefix> := <member source-name> M
      //
      // Technically, the data-member-prefix is part of the <prefix>. However,
      // since a closure type will always be mangled with a prefix, it's easier
      // to emit that last part of the prefix here.
      Decl /*P*/ Context = Lambda.getLambdaContextDecl();
      if ((Context != null)) {
        if ((isa_VarDecl(Context) || isa_FieldDecl(Context))
           && Context.getDeclContext().isRecord()) {
          {
            /*const*/ IdentifierInfo /*P*/ Name = cast_NamedDecl(Context).getIdentifier();
            if ((Name != null)) {
              mangleSourceName(Name);
              Out.$out_char($$M);
            }
          }
        }
      }
    }
    
    Out.$out(/*KEEP_STR*/"Ul");
    /*const*/ FunctionProtoType /*P*/ Proto = Lambda.getLambdaTypeInfo().getType().$arrow().getAs(FunctionProtoType.class);
    mangleBareFunctionType(Proto, /*MangleReturnType=*/ false, 
        Lambda.getLambdaStaticInvoker());
    Out.$out(/*KEEP_STR*/$E);
    
    // The number is omitted for the first closure type with a given 
    // <lambda-sig> in a given context; it is n-2 for the nth closure type 
    // (in lexical order) with that same <lambda-sig> and context.
    //
    // The AST keeps track of the number for us.
    /*uint*/int Number = Lambda.getLambdaManglingNumber();
    assert ($greater_uint(Number, 0)) : "Lambda should be mangled as an unnamed class";
    if ($greater_uint(Number, 1)) {
      mangleNumber($uint2long(Number - 2));
    }
    Out.$out_char($$UNDERSCORE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleNestedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1388,
   FQN="(anonymous namespace)::CXXNameMangler::mangleNestedName", NM="_ZN12_GLOBAL__N_114CXXNameMangler16mangleNestedNameEPKN5clang9NamedDeclEPKNS1_11DeclContextEPKN4llvm11SmallVectorINS8_9StringRefELj4EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler16mangleNestedNameEPKN5clang9NamedDeclEPKNS1_11DeclContextEPKN4llvm11SmallVectorINS8_9StringRefELj4EEEb")
  //</editor-fold>
  private void mangleNestedName(/*const*/ NamedDecl /*P*/ ND, 
                  /*const*/ DeclContext /*P*/ DC, 
                  /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    mangleNestedName(ND, 
                  DC, 
                  AdditionalAbiTags, 
                  false);
  }
  private void mangleNestedName(/*const*/ NamedDecl /*P*/ ND, 
                  /*const*/ DeclContext /*P*/ DC, 
                  /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags, 
                  boolean NoFunction/*= false*/) {
    // <nested-name> 
    //   ::= N [<CV-qualifiers>] [<ref-qualifier>] <prefix> <unqualified-name> E
    //   ::= N [<CV-qualifiers>] [<ref-qualifier>] <template-prefix> 
    //       <template-args> E
    Out.$out_char($$N);
    {
      /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(ND);
      if ((Method != null)) {
        Qualifiers MethodQuals = Qualifiers.fromCVRMask(Method.getTypeQualifiers());
        // We do not consider restrict a distinguishing attribute for overloading
        // purposes so we must not mangle it.
        MethodQuals.removeRestrict();
        mangleQualifiers(new Qualifiers(MethodQuals));
        mangleRefQualifier(Method.getRefQualifier());
      }
    }
    
    // Check if we have a template.
    type$ref</*const*/ TemplateArgumentList /*P*/ > TemplateArgs = create_type$null$ref(null);
    {
      /*const*/ TemplateDecl /*P*/ TD = isTemplate(ND, TemplateArgs);
      if ((TD != null)) {
        mangleTemplatePrefix(TD, NoFunction);
        mangleTemplateArgs($Deref(TemplateArgs.$deref()));
      } else {
        manglePrefix(DC, NoFunction);
        mangleUnqualifiedName(ND, AdditionalAbiTags);
      }
    }
    
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleNestedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1421,
   FQN="(anonymous namespace)::CXXNameMangler::mangleNestedName", NM="_ZN12_GLOBAL__N_114CXXNameMangler16mangleNestedNameEPKN5clang12TemplateDeclEPKNS1_16TemplateArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler16mangleNestedNameEPKN5clang12TemplateDeclEPKNS1_16TemplateArgumentEj")
  //</editor-fold>
  private void mangleNestedName(/*const*/ TemplateDecl /*P*/ TD, 
                  /*const*/type$ptr<TemplateArgument/*P*/> TemplateArgs, 
                  /*uint*/int NumTemplateArgs) {
    // <nested-name> ::= N [<CV-qualifiers>] <template-prefix> <template-args> E
    Out.$out_char($$N);
    
    mangleTemplatePrefix(TD);
    mangleTemplateArgs(TemplateArgs, NumTemplateArgs);
    
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::manglePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1611,
   FQN="(anonymous namespace)::CXXNameMangler::manglePrefix", NM="_ZN12_GLOBAL__N_114CXXNameMangler12manglePrefixEPN5clang19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler12manglePrefixEPN5clang19NestedNameSpecifierE")
  //</editor-fold>
  private void manglePrefix(NestedNameSpecifier /*P*/ qualifier) {
    switch (qualifier.getKind()) {
     case Global:
      // nothing
      return;
     case Super:
      throw new llvm_unreachable("Can't mangle __super specifier");
     case Namespace:
      mangleName(qualifier.getAsNamespace());
      return;
     case NamespaceAlias:
      mangleName(qualifier.getAsNamespaceAlias().getNamespace());
      return;
     case TypeSpec:
     case TypeSpecWithTemplate:
      manglePrefix(new QualType(qualifier.getAsType(), 0));
      return;
     case Identifier:
      // Member expressions can have these without prefixes, but that
      // should end up in mangleUnresolvedPrefix instead.
      assert Native.$bool(qualifier.getPrefix());
      manglePrefix(qualifier.getPrefix());
      
      mangleSourceName(qualifier.getAsIdentifier());
      return;
    }
    throw new llvm_unreachable("unexpected nested name specifier");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::manglePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1646,
   FQN="(anonymous namespace)::CXXNameMangler::manglePrefix", NM="_ZN12_GLOBAL__N_114CXXNameMangler12manglePrefixEPKN5clang11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler12manglePrefixEPKN5clang11DeclContextEb")
  //</editor-fold>
  private void manglePrefix(/*const*/ DeclContext /*P*/ DC) {
    manglePrefix(DC, false);
  }
  private void manglePrefix(/*const*/ DeclContext /*P*/ DC, boolean NoFunction/*= false*/) {
    //  <prefix> ::= <prefix> <unqualified-name>
    //           ::= <template-prefix> <template-args>
    //           ::= <template-param>
    //           ::= # empty
    //           ::= <substitution>
    DC = IgnoreLinkageSpecDecls(DC);
    if (DC.isTranslationUnit()) {
      return;
    }
    if (NoFunction && isLocalContainerContext(DC)) {
      return;
    }
    assert (!isLocalContainerContext(DC));
    
    /*const*/ NamedDecl /*P*/ ND = cast_NamedDecl(DC);
    if (mangleSubstitution(ND)) {
      return;
    }
    
    // Check if we have a template.
    type$ref</*const*/ TemplateArgumentList /*P*/ > TemplateArgs = create_type$null$ref(null);
    {
      /*const*/ TemplateDecl /*P*/ TD = isTemplate(ND, TemplateArgs);
      if ((TD != null)) {
        mangleTemplatePrefix(TD);
        mangleTemplateArgs($Deref(TemplateArgs.$deref()));
      } else {
        manglePrefix(getEffectiveDeclContext(ND), NoFunction);
        mangleUnqualifiedName(ND, (/*const*/SmallVector<StringRef> /*P*/)null);
      }
    }
    
    addSubstitution(ND);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::manglePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1027,
   FQN="(anonymous namespace)::CXXNameMangler::manglePrefix", NM="_ZN12_GLOBAL__N_114CXXNameMangler12manglePrefixEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler12manglePrefixEN5clang8QualTypeE")
  //</editor-fold>
  private void manglePrefix(QualType type) {
    {
      /*const*/ TemplateSpecializationType /*P*/ TST = type.$arrow().getAs$TemplateSpecializationType();
      if ((TST != null)) {
        if (!mangleSubstitution(new QualType(TST, 0))) {
          mangleTemplatePrefix(TST.getTemplateName());
          
          // FIXME: GCC does not appear to mangle the template arguments when
          // the template in question is a dependent template name. Should we
          // emulate that badness?
          mangleTemplateArgs(TST.getArgs(), TST.getNumArgs());
          addSubstitution(new QualType(TST, 0));
        }
      } else {
        /*const*/ DependentTemplateSpecializationType /*P*/ DTST = type.$arrow().getAs(DependentTemplateSpecializationType.class);
        if ((DTST != null)) {
          if (!mangleSubstitution(new QualType(DTST, 0))) {
            TemplateName Template = getASTContext().getDependentTemplateName(DTST.getQualifier(), DTST.getIdentifier());
            mangleTemplatePrefix(new TemplateName(Template));
            
            // FIXME: GCC does not appear to mangle the template arguments when
            // the template in question is a dependent template name. Should we
            // emulate that badness?
            mangleTemplateArgs(DTST.getArgs(), DTST.getNumArgs());
            addSubstitution(new QualType(DTST, 0));
          }
        } else {
          // We use the QualType mangle type variant here because it handles
          // substitutions.
          mangleType(new QualType(type));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplatePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1704,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplatePrefix", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleTemplatePrefixEPKN5clang12TemplateDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleTemplatePrefixEPKN5clang12TemplateDeclEb")
  //</editor-fold>
  private void mangleTemplatePrefix(/*const*/ TemplateDecl /*P*/ ND) {
    mangleTemplatePrefix(ND, 
                      false);
  }
  private void mangleTemplatePrefix(/*const*/ TemplateDecl /*P*/ ND, 
                      boolean NoFunction/*= false*/) {
    // <template-prefix> ::= <prefix> <template unqualified-name>
    //                   ::= <template-param>
    //                   ::= <substitution>
    // <template-template-param> ::= <template-param>
    //                               <substitution>
    if (mangleSubstitution(ND)) {
      return;
    }
    {
      
      // <template-template-param> ::= <template-param>
      /*const*/ TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(ND);
      if ((TTP != null)) {
        mangleTemplateParameter(TTP.getIndex());
      } else {
        manglePrefix(getEffectiveDeclContext(ND), NoFunction);
        if (isa_BuiltinTemplateDecl(ND)) {
          mangleUnqualifiedName(ND, (/*const*/SmallVector<StringRef> /*P*/)null);
        } else {
          mangleUnqualifiedName(ND.getTemplatedDecl(), (/*const*/SmallVector<StringRef> /*P*/)null);
        }
      }
    }
    
    addSubstitution(ND);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplatePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1680,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplatePrefix", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleTemplatePrefixEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleTemplatePrefixEN5clang12TemplateNameE")
  //</editor-fold>
  private void mangleTemplatePrefix(TemplateName Template) {
    {
      // <template-prefix> ::= <prefix> <template unqualified-name>
      //                   ::= <template-param>
      //                   ::= <substitution>
      TemplateDecl /*P*/ TD = Template.getAsTemplateDecl();
      if ((TD != null)) {
        mangleTemplatePrefix(TD);
        /*JAVA:return*/return;
      }
    }
    {
      
      QualifiedTemplateName /*P*/ Qualified = Template.getAsQualifiedTemplateName();
      if ((Qualified != null)) {
        manglePrefix(Qualified.getQualifier());
      }
    }
    {
      
      OverloadedTemplateStorage /*P*/ Overloaded = Template.getAsOverloadedTemplate();
      if ((Overloaded != null)) {
        mangleUnqualifiedName((/*const*/ NamedDecl /*P*/ )null, (Overloaded.begin().$star()).getDeclName(), 
            UnknownArity, (/*const*/SmallVector<StringRef> /*P*/)null);
        return;
      }
    }
    
    DependentTemplateName /*P*/ Dependent = Template.getAsDependentTemplateName();
    assert ((Dependent != null)) : "Unknown template name kind?";
    {
      NestedNameSpecifier /*P*/ Qualifier = Dependent.getQualifier();
      if ((Qualifier != null)) {
        manglePrefix(Qualifier);
      }
    }
    mangleUnscopedTemplateName(new TemplateName(Template), /* AdditionalAbiTags */ (/*const*/SmallVector<StringRef> /*P*/)null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleUnresolvedTypeOrSimpleId">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1794,
   FQN="(anonymous namespace)::CXXNameMangler::mangleUnresolvedTypeOrSimpleId", NM="_ZN12_GLOBAL__N_114CXXNameMangler30mangleUnresolvedTypeOrSimpleIdEN5clang8QualTypeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler30mangleUnresolvedTypeOrSimpleIdEN5clang8QualTypeEN4llvm9StringRefE")
  //</editor-fold>
  private boolean mangleUnresolvedTypeOrSimpleId(QualType Ty) {
    return mangleUnresolvedTypeOrSimpleId(Ty, 
                                new StringRef(/*KEEP_STR*/$EMPTY));
  }
  private boolean mangleUnresolvedTypeOrSimpleId(QualType Ty, 
                                StringRef Prefix/*= ""*/) {
    // Only certain other types are valid as prefixes;  enumerate them.
    boolean unresolvedType = false;
    Type.TypeClass tc = unresolvedType ? Type.TypeClass.SubstTemplateTypeParm : Ty.$arrow().getTypeClass();
    do {
    switch (tc) {
     case Builtin:
     case Complex:
     case Adjusted:
     case Decayed:
     case Pointer:
     case BlockPointer:
     case LValueReference:
     case RValueReference:
     case MemberPointer:
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
     case DependentSizedArray:
     case DependentSizedExtVector:
     case Vector:
     case ExtVector:
     case FunctionProto:
     case FunctionNoProto:
     case Paren:
     case Attributed:
     case Auto:
     case PackExpansion:
     case ObjCObject:
     case ObjCInterface:
     case ObjCObjectPointer:
     case Atomic:
     case Pipe:
      throw new llvm_unreachable("type is illegal as a nested name specifier");
     case SubstTemplateTypeParmPack:
      // FIXME: not clear how to mangle this!
      // template <class T...> class A {
      //   template <class U...> void foo(decltype(T::foo(U())) x...);
      // };
      Out.$out(/*KEEP_STR*/"_SUBSTPACK_");
      break;
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case TemplateTypeParm:
     case UnaryTransform:
     case SubstTemplateTypeParm:
     //unresolvedType:
      // Some callers want a prefix before the mangled type.
      Out.$out(/*NO_COPY*/Prefix);
      
      // This seems to do everything we want.  It's not really
      // sanctioned for a substituted template parameter, though.
      mangleType(new QualType(Ty));
      
      // We never want to print 'E' directly after an unresolved-type,
      // so we return directly.
      return true;
     case Typedef:
      mangleSourceNameWithAbiTags(cast_TypedefType(Ty).getDecl());
      break;
     case UnresolvedUsing:
      mangleSourceNameWithAbiTags(cast_UnresolvedUsingType(Ty).getDecl());
      break;
     case Enum:
     case Record:
      mangleSourceNameWithAbiTags(cast_TagType(Ty).getDecl());
      break;
     case TemplateSpecialization:
      {
        /*const*/ TemplateSpecializationType /*P*/ TST = cast_TemplateSpecializationType(Ty);
        TemplateName TN = TST.getTemplateName();
        switch (TN.getKind()) {
         case Template:
         case QualifiedTemplate:
          {
            TemplateDecl /*P*/ TD = TN.getAsTemplateDecl();
            
            // If the base is a template template parameter, this is an
            // unresolved type.
            assert ((TD != null)) : "no template for template specialization type";
            if (isa_TemplateTemplateParmDecl(TD)) {
              unresolvedType = true; // JAVA: instead of goto unresolvedType;
              continue; // goto unresolvedType;
            }
            
            mangleSourceNameWithAbiTags(TD);
            break;
          }
         case OverloadedTemplate:
         case DependentTemplate:
          throw new llvm_unreachable("invalid base for a template specialization type");
         case SubstTemplateTemplateParm:
          {
            SubstTemplateTemplateParmStorage /*P*/ subst = TN.getAsSubstTemplateTemplateParm();
            mangleExistingSubstitution(subst.getReplacement());
            break;
          }
         case SubstTemplateTemplateParmPack:
          {
            // FIXME: not clear how to mangle this!
            // template <template <class U> class T...> class A {
            //   template <class U...> void foo(decltype(T<U>::foo) x...);
            // };
            Out.$out(/*KEEP_STR*/"_SUBSTPACK_");
            break;
          }
        }
        
        mangleTemplateArgs(TST.getArgs(), TST.getNumArgs());
        break;
      }
     case InjectedClassName:
      mangleSourceNameWithAbiTags(cast_InjectedClassNameType(Ty).getDecl());
      break;
     case DependentName:
      mangleSourceName(cast_DependentNameType(Ty).getIdentifier());
      break;
     case DependentTemplateSpecialization:
      {
        /*const*/ DependentTemplateSpecializationType /*P*/ DTST = cast_DependentTemplateSpecializationType(Ty);
        mangleSourceName(DTST.getIdentifier());
        mangleTemplateArgs(DTST.getArgs(), DTST.getNumArgs());
        break;
      }
     case Elaborated:
      return mangleUnresolvedTypeOrSimpleId(cast_ElaboratedType(Ty).getNamedType(), new StringRef(Prefix));
    }
    } while (false);
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleOperatorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1940,
   FQN="(anonymous namespace)::CXXNameMangler::mangleOperatorName", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleOperatorNameEN5clang15DeclarationNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleOperatorNameEN5clang15DeclarationNameEj")
  //</editor-fold>
  private void mangleOperatorName(DeclarationName Name, /*uint*/int Arity) {
    switch (Name.getNameKind()) {
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXUsingDirective:
     case Identifier:
     case ObjCMultiArgSelector:
     case ObjCOneArgSelector:
     case ObjCZeroArgSelector:
      throw new llvm_unreachable("Not an operator name");
     case CXXConversionFunctionName:
      // <operator-name> ::= cv <type>    # (cast)
      Out.$out(/*KEEP_STR*/"cv");
      mangleType(Name.getCXXNameType());
      break;
     case CXXLiteralOperatorName:
      Out.$out(/*KEEP_STR*/"li");
      mangleSourceName(Name.getCXXLiteralIdentifier());
      return;
     case CXXOperatorName:
      mangleOperatorName(Name.getCXXOverloadedOperator(), Arity);
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleOperatorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1968,
   FQN="(anonymous namespace)::CXXNameMangler::mangleOperatorName", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleOperatorNameEN5clang22OverloadedOperatorKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleOperatorNameEN5clang22OverloadedOperatorKindEj")
  //</editor-fold>
  private void mangleOperatorName(OverloadedOperatorKind OO, /*uint*/int Arity) {
    switch (OO) {
     case OO_New:
      // <operator-name> ::= nw     # new
      Out.$out(/*KEEP_STR*/"nw");
      break;
     case OO_Array_New:
      //              ::= na        # new[]
      Out.$out(/*KEEP_STR*/"na");
      break;
     case OO_Delete:
      //              ::= dl        # delete
      Out.$out(/*KEEP_STR*/"dl");
      break;
     case OO_Array_Delete:
      //              ::= da        # delete[]
      Out.$out(/*KEEP_STR*/"da");
      break;
     case OO_Plus:
      //              ::= ps        # + (unary)
      //              ::= pl        # + (binary or unknown)
      Out.$out((Arity == 1 ? $("ps") : $("pl")));
      break;
     case OO_Minus:
      //              ::= ng        # - (unary)
      //              ::= mi        # - (binary or unknown)
      Out.$out((Arity == 1 ? $("ng") : $("mi")));
      break;
     case OO_Amp:
      //              ::= ad        # & (unary)
      //              ::= an        # & (binary or unknown)
      Out.$out((Arity == 1 ? $("ad") : $("an")));
      break;
     case OO_Star:
      // Use binary when unknown.
      Out.$out((Arity == 1 ? $("de") : $("ml")));
      break;
     case OO_Tilde:
      //              ::= co        # ~
      Out.$out(/*KEEP_STR*/"co");
      break;
     case OO_Slash:
      //              ::= dv        # /
      Out.$out(/*KEEP_STR*/"dv");
      break;
     case OO_Percent:
      //              ::= rm        # %
      Out.$out(/*KEEP_STR*/"rm");
      break;
     case OO_Pipe:
      //              ::= or        # |
      Out.$out(/*KEEP_STR*/"or");
      break;
     case OO_Caret:
      //              ::= eo        # ^
      Out.$out(/*KEEP_STR*/"eo");
      break;
     case OO_Equal:
      //              ::= aS        # =
      Out.$out(/*KEEP_STR*/"aS");
      break;
     case OO_PlusEqual:
      //              ::= pL        # +=
      Out.$out(/*KEEP_STR*/"pL");
      break;
     case OO_MinusEqual:
      //              ::= mI        # -=
      Out.$out(/*KEEP_STR*/"mI");
      break;
     case OO_StarEqual:
      //              ::= mL        # *=
      Out.$out(/*KEEP_STR*/"mL");
      break;
     case OO_SlashEqual:
      //              ::= dV        # /=
      Out.$out(/*KEEP_STR*/"dV");
      break;
     case OO_PercentEqual:
      //              ::= rM        # %=
      Out.$out(/*KEEP_STR*/"rM");
      break;
     case OO_AmpEqual:
      //              ::= aN        # &=
      Out.$out(/*KEEP_STR*/"aN");
      break;
     case OO_PipeEqual:
      //              ::= oR        # |=
      Out.$out(/*KEEP_STR*/"oR");
      break;
     case OO_CaretEqual:
      //              ::= eO        # ^=
      Out.$out(/*KEEP_STR*/"eO");
      break;
     case OO_LessLess:
      //              ::= ls        # <<
      Out.$out(/*KEEP_STR*/"ls");
      break;
     case OO_GreaterGreater:
      //              ::= rs        # >>
      Out.$out(/*KEEP_STR*/"rs");
      break;
     case OO_LessLessEqual:
      //              ::= lS        # <<=
      Out.$out(/*KEEP_STR*/"lS");
      break;
     case OO_GreaterGreaterEqual:
      //              ::= rS        # >>=
      Out.$out(/*KEEP_STR*/"rS");
      break;
     case OO_EqualEqual:
      //              ::= eq        # ==
      Out.$out(/*KEEP_STR*/"eq");
      break;
     case OO_ExclaimEqual:
      //              ::= ne        # !=
      Out.$out(/*KEEP_STR*/"ne");
      break;
     case OO_Less:
      //              ::= lt        # <
      Out.$out(/*KEEP_STR*/"lt");
      break;
     case OO_Greater:
      //              ::= gt        # >
      Out.$out(/*KEEP_STR*/"gt");
      break;
     case OO_LessEqual:
      //              ::= le        # <=
      Out.$out(/*KEEP_STR*/"le");
      break;
     case OO_GreaterEqual:
      //              ::= ge        # >=
      Out.$out(/*KEEP_STR*/"ge");
      break;
     case OO_Exclaim:
      //              ::= nt        # !
      Out.$out(/*KEEP_STR*/$nt);
      break;
     case OO_AmpAmp:
      //              ::= aa        # &&
      Out.$out(/*KEEP_STR*/"aa");
      break;
     case OO_PipePipe:
      //              ::= oo        # ||
      Out.$out(/*KEEP_STR*/"oo");
      break;
     case OO_PlusPlus:
      //              ::= pp        # ++
      Out.$out(/*KEEP_STR*/"pp");
      break;
     case OO_MinusMinus:
      //              ::= mm        # --
      Out.$out(/*KEEP_STR*/"mm");
      break;
     case OO_Comma:
      //              ::= cm        # ,
      Out.$out(/*KEEP_STR*/"cm");
      break;
     case OO_ArrowStar:
      //              ::= pm        # ->*
      Out.$out(/*KEEP_STR*/"pm");
      break;
     case OO_Arrow:
      //              ::= pt        # ->
      Out.$out(/*KEEP_STR*/"pt");
      break;
     case OO_Call:
      //              ::= cl        # ()
      Out.$out(/*KEEP_STR*/"cl");
      break;
     case OO_Subscript:
      //              ::= ix        # []
      Out.$out(/*KEEP_STR*/"ix");
      break;
     case OO_Conditional:
      
      //              ::= qu        # ?
      // The conditional operator can't be overloaded, but we still handle it when
      // mangling expressions.
      Out.$out(/*KEEP_STR*/"qu");
      break;
     case OO_Coawait:
      // Proposal on cxx-abi-dev, 2015-10-21.
      //              ::= aw        # co_await
      Out.$out(/*KEEP_STR*/"aw");
      break;
     case OO_None:
     case NUM_OVERLOADED_OPERATORS:
      throw new llvm_unreachable("Not an overloaded operator");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleVendorQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2155,
   FQN="(anonymous namespace)::CXXNameMangler::mangleVendorQualifier", NM="_ZN12_GLOBAL__N_114CXXNameMangler21mangleVendorQualifierEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler21mangleVendorQualifierEN4llvm9StringRefE")
  //</editor-fold>
  private void mangleVendorQualifier(StringRef name) {
    Out.$out_char($$U).$out_uint(name.size()).$out(/*NO_COPY*/name);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2079,
   FQN="(anonymous namespace)::CXXNameMangler::mangleQualifiers", NM="_ZN12_GLOBAL__N_114CXXNameMangler16mangleQualifiersEN5clang10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler16mangleQualifiersEN5clang10QualifiersE")
  //</editor-fold>
  private void mangleQualifiers(Qualifiers Quals) {
    // Vendor qualifiers come first.
    
    // Address space qualifiers start with an ordinary letter.
    if (Quals.hasAddressSpace()) {
      // Address space extension:
      //
      //   <type> ::= U <target-addrspace>
      //   <type> ::= U <OpenCL-addrspace>
      //   <type> ::= U <CUDA-addrspace>
      SmallString/*64*/ ASString/*J*/= new SmallString/*64*/(64);
      /*uint*/int AS = Quals.getAddressSpace();
      if (Context.getASTContext().addressSpaceMapManglingFor(AS)) {
        //  <target-addrspace> ::= "AS" <address-space-number>
        /*uint*/int TargetAS = Context.getASTContext().getTargetAddressSpace(AS);
        ASString.$assign(new StringRef($add_T$C$P_string(/*KEEP_STR*/"AS", llvm.utostr($uint2ulong(TargetAS)))));
      } else {
        switch (AS) {
         default:
          throw new llvm_unreachable("Not a language specific address space");
         case LangAS.ID.opencl_global:
          //  <OpenCL-addrspace> ::= "CL" [ "global" | "local" | "constant" ]
          ASString.$assign(/*STRINGREF_STR*/"CLglobal");
          break;
         case LangAS.ID.opencl_local:
          ASString.$assign(/*STRINGREF_STR*/"CLlocal");
          break;
         case LangAS.ID.opencl_constant:
          ASString.$assign(/*STRINGREF_STR*/"CLconstant");
          break;
         case LangAS.ID.cuda_device:
          //  <CUDA-addrspace> ::= "CU" [ "device" | "constant" | "shared" ]
          ASString.$assign(/*STRINGREF_STR*/"CUdevice");
          break;
         case LangAS.ID.cuda_constant:
          ASString.$assign(/*STRINGREF_STR*/"CUconstant");
          break;
         case LangAS.ID.cuda_shared:
          ASString.$assign(/*STRINGREF_STR*/"CUshared");
          break;
        }
      }
      mangleVendorQualifier(ASString.$StringRef());
    }
    
    // The ARC ownership qualifiers start with underscores.
    switch (Quals.getObjCLifetime()) {
     case OCL_None:
      // Objective-C ARC Extension:
      //
      //   <type> ::= U "__strong"
      //   <type> ::= U "__weak"
      //   <type> ::= U "__autoreleasing"
      break;
     case OCL_Weak:
      mangleVendorQualifier(new StringRef(/*KEEP_STR*/"__weak"));
      break;
     case OCL_Strong:
      mangleVendorQualifier(new StringRef(/*KEEP_STR*/"__strong"));
      break;
     case OCL_Autoreleasing:
      mangleVendorQualifier(new StringRef(/*KEEP_STR*/"__autoreleasing"));
      break;
     case OCL_ExplicitNone:
      // The __unsafe_unretained qualifier is *not* mangled, so that
      // __unsafe_unretained types in ARC produce the same manglings as the
      // equivalent (but, naturally, unqualified) types in non-ARC, providing
      // better ABI compatibility.
      //
      // It's safe to do this because unqualified 'id' won't show up
      // in any type signatures that need to be mangled.
      break;
    }
    
    // <CV-qualifiers> ::= [r] [V] [K]    # restrict (C99), volatile, const
    if (Quals.hasRestrict()) {
      Out.$out_char($$r);
    }
    if (Quals.hasVolatile()) {
      Out.$out_char($$V);
    }
    if (Quals.hasConst()) {
      Out.$out_char($$K);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleRefQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2159,
   FQN="(anonymous namespace)::CXXNameMangler::mangleRefQualifier", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleRefQualifierEN5clang16RefQualifierKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleRefQualifierEN5clang16RefQualifierKindE")
  //</editor-fold>
  private void mangleRefQualifier(RefQualifierKind RefQualifier) {
    // <ref-qualifier> ::= R                # lvalue reference
    //                 ::= O                # rvalue-reference
    switch (RefQualifier) {
     case RQ_None:
      break;
     case RQ_LValue:
      Out.$out_char($$R);
      break;
     case RQ_RValue:
      Out.$out_char($$O);
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleObjCMethodName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2176,
   FQN="(anonymous namespace)::CXXNameMangler::mangleObjCMethodName", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleObjCMethodNameEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleObjCMethodNameEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  private void mangleObjCMethodName(/*const*/ ObjCMethodDecl /*P*/ MD) {
    Context.mangleObjCMethodName(MD, Out);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2278,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang11BuiltinTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang11BuiltinTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ BuiltinType /*P*/ T) {
    //  <type>         ::= <builtin-type>
    //  <builtin-type> ::= v  # void
    //                 ::= w  # wchar_t
    //                 ::= b  # bool
    //                 ::= c  # char
    //                 ::= a  # signed char
    //                 ::= h  # unsigned char
    //                 ::= s  # short
    //                 ::= t  # unsigned short
    //                 ::= i  # int
    //                 ::= j  # unsigned int
    //                 ::= l  # long
    //                 ::= m  # unsigned long
    //                 ::= x  # long long, __int64
    //                 ::= y  # unsigned long long, __int64
    //                 ::= n  # __int128
    //                 ::= o  # unsigned __int128
    //                 ::= f  # float
    //                 ::= d  # double
    //                 ::= e  # long double, __float80
    //                 ::= g  # __float128
    // UNSUPPORTED:    ::= Dd # IEEE 754r decimal floating point (64 bits)
    // UNSUPPORTED:    ::= De # IEEE 754r decimal floating point (128 bits)
    // UNSUPPORTED:    ::= Df # IEEE 754r decimal floating point (32 bits)
    //                 ::= Dh # IEEE 754r half-precision floating point (16 bits)
    //                 ::= Di # char32_t
    //                 ::= Ds # char16_t
    //                 ::= Dn # std::nullptr_t (i.e., decltype(nullptr))
    //                 ::= u <source-name>    # vendor extended type
    std.string type_name/*J*/= new std.string();
    switch (T.getKind()) {
     case Void:
      Out.$out_char($$v);
      break;
     case Bool:
      Out.$out_char($$b);
      break;
     case Char_U:
     case Char_S:
      Out.$out_char($$c);
      break;
     case UChar:
      Out.$out_char($$h);
      break;
     case UShort:
      Out.$out_char($$t);
      break;
     case UInt:
      Out.$out_char($$j);
      break;
     case ULong:
      Out.$out_char($$m);
      break;
     case ULongLong:
      Out.$out_char($$y);
      break;
     case UInt128:
      Out.$out_char($$o);
      break;
     case SChar:
      Out.$out_char($$a);
      break;
     case WChar_S:
     case WChar_U:
      Out.$out_char($$w);
      break;
     case Char16:
      Out.$out(/*KEEP_STR*/"Ds");
      break;
     case Char32:
      Out.$out(/*KEEP_STR*/"Di");
      break;
     case Short:
      Out.$out_char($$s);
      break;
     case Int:
      Out.$out_char($$i);
      break;
     case Long:
      Out.$out_char($$l);
      break;
     case LongLong:
      Out.$out_char($$x);
      break;
     case Int128:
      Out.$out_char($$n);
      break;
     case Half:
      Out.$out(/*KEEP_STR*/"Dh");
      break;
     case Float:
      Out.$out_char($$f);
      break;
     case Double:
      Out.$out_char($$d);
      break;
     case LongDouble:
      Out.$out_char((getASTContext().getTargetInfo().useFloat128ManglingForLongDouble() ? $$g : $$e));
      break;
     case Float128:
      if (getASTContext().getTargetInfo().useFloat128ManglingForLongDouble()) {
        Out.$out(/*KEEP_STR*/"U10__float128"); // Match the GCC mangling
      } else {
        Out.$out_char($$g);
      }
      break;
     case NullPtr:
      Out.$out(/*KEEP_STR*/"Dn");
      break;
     case Overload:
     case BoundMember:
     case PseudoObject:
     case UnknownAny:
     case BuiltinFn:
     case ARCUnbridgedCast:
     case OMPArraySection:
     case Dependent:
      if (!NullOut) {
        throw new llvm_unreachable("mangling a placeholder type");
      }
      break;
     case ObjCId:
      Out.$out(/*KEEP_STR*/"11objc_object");
      break;
     case ObjCClass:
      Out.$out(/*KEEP_STR*/"10objc_class");
      break;
     case ObjCSel:
      Out.$out(/*KEEP_STR*/"13objc_selector");
      break;
     case OCLImage1dRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dArrayRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_array_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dBufferRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_buffer_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dDepthRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_depth_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayDepthRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_depth_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dMSAARO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_msaa_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayMSAARO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_msaa_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dMSAADepthRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_msaa_depth_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayMSAADepthRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_msaa_depth_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage3dRO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image3d_ro");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dArrayWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_array_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dBufferWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_buffer_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dDepthWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_depth_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayDepthWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_depth_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dMSAAWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_msaa_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayMSAAWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_msaa_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dMSAADepthWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_msaa_depth_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayMSAADepthWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_msaa_depth_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage3dWO:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image3d_wo");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dArrayRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_array_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage1dBufferRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image1d_buffer_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dDepthRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_depth_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayDepthRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_depth_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dMSAARW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_msaa_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayMSAARW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_msaa_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dMSAADepthRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_msaa_depth_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage2dArrayMSAADepthRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image2d_array_msaa_depth_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLImage3dRW:
      type_name.$assign_T$C$P(/*KEEP_STR*/"ocl_image3d_rw");
      Out.$out_uint(type_name.size()).$out(type_name);
      break;
     case OCLSampler:
      Out.$out(/*KEEP_STR*/"11ocl_sampler");
      break;
     case OCLEvent:
      Out.$out(/*KEEP_STR*/"9ocl_event");
      break;
     case OCLClkEvent:
      Out.$out(/*KEEP_STR*/"12ocl_clkevent");
      break;
     case OCLQueue:
      Out.$out(/*KEEP_STR*/"9ocl_queue");
      break;
     case OCLNDRange:
      Out.$out(/*KEEP_STR*/"11ocl_ndrange");
      break;
     case OCLReserveID:
      Out.$out(/*KEEP_STR*/"13ocl_reserveid");
      break;
    }
  }

  
  // <type> ::= C <type>   # complex pair (C 2000)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2713,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang11ComplexTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ ComplexType /*P*/ T) {
    Out.$out_char($$C);
    mangleType(T.getElementType());
  }

  
  // <type> ::= P <type>   # pointer-to
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2691,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang11PointerTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ PointerType /*P*/ T) {
    Out.$out_char($$P);
    mangleType(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2915,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang16BlockPointerTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ BlockPointerType /*P*/ T) {
    Out.$out(/*KEEP_STR*/"U13block_pointer");
    mangleType(T.getPointeeType());
  }

  
  // <type> ::= R <type>   # reference-to
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2701,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19LValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19LValueReferenceTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ LValueReferenceType /*P*/ T) {
    Out.$out_char($$R);
    mangleType(T.getPointeeType());
  }

  
  // <type> ::= O <type>   # rvalue reference-to (C++0x)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2707,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19RValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19RValueReferenceTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ RValueReferenceType /*P*/ T) {
    Out.$out_char($$O);
    mangleType(T.getPointeeType());
  }

  
  // <type>                   ::= <pointer-to-member-type>
  // <pointer-to-member-type> ::= M <class type> <member type>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2648,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ MemberPointerType /*P*/ T) {
    Out.$out_char($$M);
    mangleType(new QualType(T.__getClass(), 0));
    QualType PointeeType = T.getPointeeType();
    {
      /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(PointeeType);
      if ((FPT != null)) {
        mangleType(FPT);
        
        // Itanium C++ ABI 5.1.8:
        //
        //   The type of a non-static member function is considered to be different,
        //   for the purposes of substitution, from the type of a namespace-scope or
        //   static member function whose type appears similar. The types of two
        //   non-static member functions are considered to be different, for the
        //   purposes of substitution, if the functions are members of different
        //   classes. In other words, for the purposes of substitution, the class of 
        //   which the function is a member is considered part of the type of 
        //   function.
        
        // Given that we already substitute member function pointers as a
        // whole, the net effect of this rule is just to unconditionally
        // suppress substitution on the function type in a member pointer.
        // We increment the SeqID here to emulate adding an entry to the
        // substitution table.
        ++SeqID;
      } else {
        mangleType(new QualType(PointeeType));
      }
    }
  }

  
  // <type>       ::= <array-type>
  // <array-type> ::= A <positive dimension number> _ <element type>
  //              ::= A [<dimension expression>] _ <element type>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2623,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17ConstantArrayTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ ConstantArrayType /*P*/ T) {
    $out_raw_ostream_APInt$C(Out.$out_char($$A), T.getSize()).$out_char($$UNDERSCORE);
    mangleType(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2641,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19IncompleteArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19IncompleteArrayTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ IncompleteArrayType /*P*/ T) {
    Out.$out(/*KEEP_STR*/"A_");
    mangleType(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2627,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17VariableArrayTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ VariableArrayType /*P*/ T) {
    Out.$out_char($$A);
    // decayed vla types (size 0) will just be skipped.
    if ((T.getSizeExpr() != null)) {
      mangleExpression(T.getSizeExpr());
    }
    Out.$out_char($$UNDERSCORE);
    mangleType(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2635,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang23DependentSizedArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang23DependentSizedArrayTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentSizedArrayType /*P*/ T) {
    Out.$out_char($$A);
    mangleExpression(T.getSizeExpr());
    Out.$out_char($$UNDERSCORE);
    mangleType(T.getElementType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2870,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang27DependentSizedExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang27DependentSizedExtVectorTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentSizedExtVectorType /*P*/ T) {
    Out.$out(/*KEEP_STR*/"Dv");
    mangleExpression(T.getSizeExpr());
    Out.$out_char($$UNDERSCORE);
    mangleType(T.getElementType());
  }

  
  // GNU extension: vector types
  // <type>                  ::= <vector-type>
  // <vector-type>           ::= Dv <positive dimension number> _
  //                                    <extended element type>
  //                         ::= Dv [<dimension expression>] _ <element type>
  // <extended element type> ::= <element type>
  //                         ::= p # AltiVec vector pixel
  //                         ::= b # Altivec vector bool
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2846,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10VectorTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ VectorType /*P*/ T) {
    if ((T.getVectorKind() == VectorType.VectorKind.NeonVector
       || T.getVectorKind() == VectorType.VectorKind.NeonPolyVector)) {
      Triple Target = new Triple(getASTContext().getTargetInfo().getTriple());
      Triple.ArchType Arch = getASTContext().getTargetInfo().getTriple().getArch();
      if ((Arch == Triple.ArchType.aarch64
         || Arch == Triple.ArchType.aarch64_be) && !Target.isOSDarwin()) {
        mangleAArch64NeonVectorType(T);
      } else {
        mangleNeonVectorType(T);
      }
      return;
    }
    Out.$out(/*KEEP_STR*/"Dv").$out_uint(T.getNumElements()).$out_char($$UNDERSCORE);
    if (T.getVectorKind() == VectorType.VectorKind.AltiVecPixel) {
      Out.$out_char($$p);
    } else if (T.getVectorKind() == VectorType.VectorKind.AltiVecBool) {
      Out.$out_char($$b);
    } else {
      mangleType(T.getElementType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2867,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang13ExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang13ExtVectorTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ ExtVectorType /*P*/ T) {
    mangleType(((/*static_cast*//*const*/ VectorType /*P*/ )(T)));
  }

  
  // <type>          ::= <function-type>
  // <function-type> ::= [<CV-qualifiers>] F [Y]
  //                      <bare-function-type> [<ref-qualifier>] E
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2505,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17FunctionProtoTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ FunctionProtoType /*P*/ T) {
    mangleExtFunctionInfo(T);
    
    // Mangle CV-qualifiers, if present.  These are 'this' qualifiers,
    // e.g. "const" in "int (A::*)() const".
    mangleQualifiers(Qualifiers.fromCVRMask(T.getTypeQuals()));
    
    Out.$out_char($$F);
    
    // FIXME: We don't have enough information in the AST to produce the 'Y'
    // encoding for extern "C" function types.
    mangleBareFunctionType(T, /*MangleReturnType=*/ true);
    
    // Mangle the ref-qualifier, if present.
    mangleRefQualifier(T.getRefQualifier());
    
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2524,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19FunctionNoProtoTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ FunctionNoProtoType /*P*/ T) {
    // Function types without prototypes can arise when mangling a function type
    // within an overloadable function in C. We mangle these as the absence of any
    // parameter types (not even an empty parameter list).
    Out.$out_char($$F);
    
    FunctionTypeDepthState saved = FunctionTypeDepth.push();
    
    FunctionTypeDepth.enterResultType();
    mangleType(T.getReturnType());
    FunctionTypeDepth.leaveResultType();
    
    FunctionTypeDepth.pop(new FunctionTypeDepthState(saved));
    Out.$out_char($$E);
  }

  
  // <type>            ::= <class-enum-type>
  // <class-enum-type> ::= <name>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2604,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19UnresolvedUsingTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang19UnresolvedUsingTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ UnresolvedUsingType /*P*/ T) {
    mangleName(T.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3002,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang14TypeOfExprTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang14TypeOfExprTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ TypeOfExprType /*P*/ T) {
    // FIXME: this is pretty unsatisfactory, but there isn't an obvious
    // "extension with parameters" mangling.
    Out.$out(/*KEEP_STR*/"u6typeof");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2996,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10TypeOfTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10TypeOfTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ TypeOfType /*P*/ T) {
    // FIXME: this is pretty unsatisfactory, but there isn't an obvious
    // "extension with parameters" mangling.
    Out.$out(/*KEEP_STR*/"u6typeof");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3008,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang12DecltypeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang12DecltypeTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ DecltypeType /*P*/ T) {
    Expr /*P*/ E = T.getUnderlyingExpr();
    
    // type ::= Dt <expression> E  # decltype of an id-expression
    //                             #   or class member access
    //      ::= DT <expression> E  # decltype of an expression
    
    // This purports to be an exhaustive list of id-expressions and
    // class member accesses.  Note that we do not ignore parentheses;
    // parentheses change the semantics of decltype for these
    // expressions (and cause the mangler to use the other form).
    if (isa_DeclRefExpr(E)
       || isa_MemberExpr(E)
       || isa_UnresolvedLookupExpr(E)
       || isa_DependentScopeDeclRefExpr(E)
       || isa_CXXDependentScopeMemberExpr(E)
       || isa_UnresolvedMemberExpr(E)) {
      Out.$out(/*KEEP_STR*/"Dt");
    } else {
      Out.$out(/*KEEP_STR*/"DT");
    }
    mangleExpression(E);
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3032,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang18UnaryTransformTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang18UnaryTransformTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ UnaryTransformType /*P*/ T) {
    // If this is dependent, we need to record that. If not, we simply
    // mangle it as the underlying type since they are equivalent.
    if (T.isDependentType()) {
      Out.$out_char($$U);
      switch (T.getUTTKind()) {
       case EnumUnderlyingType:
        Out.$out(/*KEEP_STR*/"3eut");
        break;
      }
    }
    
    mangleType(T.getBaseType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2613,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10RecordTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ RecordType /*P*/ T) {
    mangleType(((/*static_cast*//*const*/ TagType /*P*/ )(T)));
  }

  
  // <type>            ::= <class-enum-type>
  // <class-enum-type> ::= <name>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2610,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang8EnumTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ EnumType /*P*/ T) {
    mangleType(((/*static_cast*//*const*/ TagType /*P*/ )(T)));
  }

  
  // <type>           ::= <template-param>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2677,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang20TemplateTypeParmTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ TemplateTypeParmType /*P*/ T) {
    mangleTemplateParameter(T.getIndex());
  }

  
  // <type>           ::= <template-param>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2682,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang29SubstTemplateTypeParmPackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang29SubstTemplateTypeParmPackTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ SubstTemplateTypeParmPackType /*P*/ T) {
    // FIXME: not clear how to mangle this!
    // template <class T...> class A {
    //   template <class U...> void foo(T(*)(U) x...);
    // };
    Out.$out(/*KEEP_STR*/"_SUBSTPACK_");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2927,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang26TemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang26TemplateSpecializationTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ TemplateSpecializationType /*P*/ T) {
    {
      TemplateDecl /*P*/ TD = T.getTemplateName().getAsTemplateDecl();
      if ((TD != null)) {
        mangleTemplateName(TD, T.getArgs(), T.getNumArgs());
      } else {
        if (mangleSubstitution(new QualType(T, 0))) {
          return;
        }
        
        mangleTemplatePrefix(T.getTemplateName());
        
        // FIXME: GCC does not appear to mangle the template arguments when
        // the template in question is a dependent template name. Should we
        // emulate that badness?
        mangleTemplateArgs(T.getArgs(), T.getNumArgs());
        addSubstitution(new QualType(T, 0));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3048,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang8AutoTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ AutoType /*P*/ T) {
    QualType D = T.getDeducedType();
    // <builtin-type> ::= Da  # dependent auto
    if (D.isNull()) {
      assert (T.getKeyword() != AutoTypeKeyword.GNUAutoType) : "shouldn't need to mangle __auto_type!";
      Out.$out((T.isDecltypeAuto() ? $("Dc") : $("Da")));
    } else {
      mangleType(new QualType(D));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2920,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang21InjectedClassNameTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ InjectedClassNameType /*P*/ T) {
    // Mangle injected class name types as if the user had written the
    // specialization out fully.  It may not actually be possible to see
    // this mangling, though.
    mangleType(T.getInjectedSpecializationType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2944,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17DependentNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17DependentNameTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentNameType /*P*/ T) {
    // Proposal by cxx-abi-dev, 2014-03-26
    // <class-enum-type> ::= <name>    # non-dependent or dependent type name or
    //                                 # dependent elaborated type specifier using
    //                                 # 'typename'
    //                   ::= Ts <name> # dependent elaborated type specifier using
    //                                 # 'struct' or 'class'
    //                   ::= Tu <name> # dependent elaborated type specifier using
    //                                 # 'union'
    //                   ::= Te <name> # dependent elaborated type specifier using
    //                                 # 'enum'
    switch (T.getKeyword()) {
     case ETK_Typename:
      break;
     case ETK_Struct:
     case ETK_Class:
     case ETK_Interface:
      Out.$out(/*KEEP_STR*/"Ts");
      break;
     case ETK_Union:
      Out.$out(/*KEEP_STR*/"Tu");
      break;
     case ETK_Enum:
      Out.$out(/*KEEP_STR*/"Te");
      break;
     default:
      throw new llvm_unreachable("unexpected keyword for dependent type name");
    }
    // Typename types are always nested
    Out.$out_char($$N);
    manglePrefix(T.getQualifier());
    mangleSourceName(T.getIdentifier());
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2979,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang35DependentTemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang35DependentTemplateSpecializationTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ DependentTemplateSpecializationType /*P*/ T) {
    // Dependently-scoped template types are nested if they have a prefix.
    Out.$out_char($$N);
    
    // TODO: avoid making this TemplateName.
    TemplateName Prefix = getASTContext().getDependentTemplateName(T.getQualifier(), 
        T.getIdentifier());
    mangleTemplatePrefix(new TemplateName(Prefix));
    
    // FIXME: GCC does not appear to mangle the template arguments when
    // the template in question is a dependent template name. Should we
    // emulate that badness?
    mangleTemplateArgs(T.getArgs(), T.getNumArgs());
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2877,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17PackExpansionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17PackExpansionTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ PackExpansionType /*P*/ T) {
    // <type>  ::= Dp <type>          # pack expansion (C++0x)
    Out.$out(/*KEEP_STR*/"Dp");
    mangleType(T.getPattern());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2887,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang14ObjCObjectTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ ObjCObjectType /*P*/ T) {
    // Treat __kindof as a vendor extended type qualifier.
    if (T.isKindOfType()) {
      Out.$out(/*KEEP_STR*/"U8__kindof");
    }
    if (!T.qual_empty()) {
      raw_svector_ostream QualOS = null;
      try {
        // Mangle protocol qualifiers.
        SmallString/*64*/ QualStr/*J*/= new SmallString/*64*/(64);
        QualOS/*J*/= new raw_svector_ostream(QualStr);
        QualOS.$out(/*KEEP_STR*/"objcproto");
        for (/*const*/ ObjCProtocolDecl /*P*/ I : T.quals()) {
          StringRef name = I.getName();
          QualOS.$out_uint(name.size()).$out(/*NO_COPY*/name);
        }
        Out.$out_char($$U).$out_uint(QualStr.size()).$out(QualStr);
      } finally {
        if (QualOS != null) { QualOS.$destroy(); }
      }
    }
    
    mangleType(T.getBaseType());
    if (T.isSpecialized()) {
      // Mangle type arguments as I <type>+ E
      Out.$out_char($$I);
      for (QualType typeArg : T.getTypeArgs())  {
        mangleType(new QualType(typeArg));
      }
      Out.$out_char($$E);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2883,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17ObjCInterfaceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang17ObjCInterfaceTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ ObjCInterfaceType /*P*/ T) {
    mangleSourceName(T.getDecl().getIdentifier());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2695,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang21ObjCObjectPointerTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ ObjCObjectPointerType /*P*/ T) {
    Out.$out_char($$P);
    mangleType(T.getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3066,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang8PipeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang8PipeTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ PipeType /*P*/ T) {
    // Pipe type mangling rules are described in SPIR 2.0 specification
    // A.1 Data types and A.3 Summary of changes
    // <type> ::= 8ocl_pipe
    Out.$out(/*KEEP_STR*/"8ocl_pipe");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3059,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10AtomicTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang10AtomicTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ AtomicType /*P*/ T) {
    // <type> ::= U <source-name> <type>  # vendor extended type qualifier
    // (Until there's a standardized mangling...)
    Out.$out(/*KEEP_STR*/"U7_Atomic");
    mangleType(T.getValueType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2616,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang7TagTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEPKN5clang7TagTypeE")
  //</editor-fold>
  private void mangleType(/*const*/ TagType /*P*/ T) {
    mangleName(T.getDecl());
  }

  
  /// Mangles a template name under the production <type>.  Required for
  /// template template arguments.
  ///   <type> ::= <class-enum-type>
  ///          ::= <template-param>
  ///          ::= <substitution>
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 1734,
   FQN="(anonymous namespace)::CXXNameMangler::mangleType", NM="_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEN5clang12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler10mangleTypeEN5clang12TemplateNameE")
  //</editor-fold>
  private void mangleType(TemplateName TN) {
    if (mangleSubstitution(new TemplateName(TN))) {
      return;
    }
    
    TemplateDecl /*P*/ TD = null;
    boolean HaveDecl = false; // JAVA
    switch (TN.getKind()) {
     case QualifiedTemplate:
      TD = TN.getAsQualifiedTemplateName().getTemplateDecl();
      // goto HaveDecl;
      HaveDecl = true; // JAVA: and fall through instead of goto HaveDecl;
     case Template:
      if (!HaveDecl) {
        TD = TN.getAsTemplateDecl();
      }
      //goto HaveDecl;
     //HaveDecl:
      if (isa_TemplateTemplateParmDecl(TD)) {
        mangleTemplateParameter(cast_TemplateTemplateParmDecl(TD).getIndex());
      } else {
        mangleName(TD);
      }
      break;
     case OverloadedTemplate:
      throw new llvm_unreachable("can't mangle an overloaded template name as a <type>");
     case DependentTemplate:
      {
        /*const*/ DependentTemplateName /*P*/ Dependent = TN.getAsDependentTemplateName();
        assert (Dependent.isIdentifier());
        
        // <class-enum-type> ::= <name>
        // <name> ::= <nested-name>
        mangleUnresolvedPrefix(Dependent.getQualifier());
        mangleSourceName(Dependent.getIdentifier());
        break;
      }
     case SubstTemplateTemplateParm:
      {
        // Substituted template parameters are mangled as the substituted
        // template.  This will check for the substitution twice, which is
        // fine, but we have to return early so that we don't try to *add*
        // the substitution twice.
        SubstTemplateTemplateParmStorage /*P*/ subst = TN.getAsSubstTemplateTemplateParm();
        mangleType(subst.getReplacement());
        return;
      }
     case SubstTemplateTemplateParmPack:
      {
        // FIXME: not clear how to mangle this!
        // template <template <class> class T...> class A {
        //   template <template <class> class U...> void foo(B<T,U> x...);
        // };
        Out.$out(/*KEEP_STR*/"_SUBSTPACK_");
        break;
      }
    }
    
    addSubstitution(new TemplateName(TN));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::getCallingConvQualifierName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2434,
   FQN="(anonymous namespace)::CXXNameMangler::getCallingConvQualifierName", NM="_ZN12_GLOBAL__N_114CXXNameMangler27getCallingConvQualifierNameEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler27getCallingConvQualifierNameEN5clang11CallingConvE")
  //</editor-fold>
  private static StringRef getCallingConvQualifierName(CallingConv CC) {
    switch (CC) {
     case CC_C:
      return new StringRef(/*KEEP_STR*/$EMPTY);
     case CC_X86StdCall:
     case CC_X86FastCall:
     case CC_X86ThisCall:
     case CC_X86VectorCall:
     case CC_X86Pascal:
     case CC_X86_64Win64:
     case CC_X86_64SysV:
     case CC_AAPCS:
     case CC_AAPCS_VFP:
     case CC_IntelOclBicc:
     case CC_SpirFunction:
     case CC_OpenCLKernel:
     case CC_PreserveMost:
     case CC_PreserveAll:
      // FIXME: we should be mangling all of the above.
      return new StringRef(/*KEEP_STR*/$EMPTY);
     case CC_Swift:
      return new StringRef(/*KEEP_STR*/"swiftcall");
    }
    throw new llvm_unreachable("bad calling convention");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleExtParameterInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2479,
   FQN="(anonymous namespace)::CXXNameMangler::mangleExtParameterInfo", NM="_ZN12_GLOBAL__N_114CXXNameMangler22mangleExtParameterInfoEN5clang17FunctionProtoType16ExtParameterInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22mangleExtParameterInfoEN5clang17FunctionProtoType16ExtParameterInfoE")
  //</editor-fold>
  private void mangleExtParameterInfo(FunctionProtoType.ExtParameterInfo PI) {
    // Vendor-specific qualifiers are emitted in reverse alphabetical order.
    
    // Note that these are *not* substitution candidates.  Demanglers might
    // have trouble with this if the parameter type is fully substituted.
    switch (PI.getABI()) {
     case Ordinary:
      break;
     case SwiftContext:
     case SwiftErrorResult: 
     case SwiftIndirectResult:
      
      // All of these start with "swift", so they come before "ns_consumed".
      mangleVendorQualifier(getParameterABISpelling(PI.getABI()));
      break;
    }
    if (PI.isConsumed()) {
      mangleVendorQualifier(new StringRef(/*KEEP_STR*/"ns_consumed"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleExtFunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2462,
   FQN="(anonymous namespace)::CXXNameMangler::mangleExtFunctionInfo", NM="_ZN12_GLOBAL__N_114CXXNameMangler21mangleExtFunctionInfoEPKN5clang12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler21mangleExtFunctionInfoEPKN5clang12FunctionTypeE")
  //</editor-fold>
  private void mangleExtFunctionInfo(/*const*/ FunctionType /*P*/ T) {
    // Fast path.
    if (T.getExtInfo().$eq(new FunctionType.ExtInfo())) {
      return;
    }
    
    // Vendor-specific qualifiers are emitted in reverse alphabetical order.
    // This will get more complicated in the future if we mangle other
    // things here; but for now, since we mangle ns_returns_retained as
    // a qualifier on the result type, we can get away with this:
    StringRef CCQualifier = getCallingConvQualifierName(T.getExtInfo().getCC());
    if (!CCQualifier.empty()) {
      mangleVendorQualifier(new StringRef(CCQualifier));
    }
    // FIXME: regparm
    // FIXME: noreturn
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleBareFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2540,
   FQN="(anonymous namespace)::CXXNameMangler::mangleBareFunctionType", NM="_ZN12_GLOBAL__N_114CXXNameMangler22mangleBareFunctionTypeEPKN5clang17FunctionProtoTypeEbPKNS1_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22mangleBareFunctionTypeEPKN5clang17FunctionProtoTypeEbPKNS1_12FunctionDeclE")
  //</editor-fold>
  private void mangleBareFunctionType(/*const*/ FunctionProtoType /*P*/ Proto, 
                        boolean MangleReturnType) {
    mangleBareFunctionType(Proto, 
                        MangleReturnType, 
                        (/*const*/ FunctionDecl /*P*/ )null);
  }
  private void mangleBareFunctionType(/*const*/ FunctionProtoType /*P*/ Proto, 
                        boolean MangleReturnType, 
                        /*const*/ FunctionDecl /*P*/ FD/*= null*/) {
    // Record that we're in a function type.  See mangleFunctionParam
    // for details on what we're trying to achieve here.
    FunctionTypeDepthState saved = FunctionTypeDepth.push();
    
    // <bare-function-type> ::= <signature type>+
    if (MangleReturnType) {
      FunctionTypeDepth.enterResultType();
      
      // Mangle ns_returns_retained as an order-sensitive qualifier here.
      if (Proto.getExtInfo().getProducesResult() && FD == null) {
        mangleVendorQualifier(new StringRef(/*KEEP_STR*/"ns_returns_retained"));
      }
      
      // Mangle the return type without any direct ARC ownership qualifiers.
      QualType ReturnTy = Proto.getReturnType();
      if ((ReturnTy.getObjCLifetime().getValue() != 0)) {
        SplitQualType SplitReturnTy = ReturnTy.split();
        SplitReturnTy.Quals.removeObjCLifetime();
        ReturnTy.$assignMove(getASTContext().getQualifiedType(new SplitQualType(SplitReturnTy)));
      }
      mangleType(new QualType(ReturnTy));
      
      FunctionTypeDepth.leaveResultType();
    }
    if (Proto.getNumParams() == 0 && !Proto.isVariadic()) {
      //   <builtin-type> ::= v   # void
      Out.$out_char($$v);
      
      FunctionTypeDepth.pop(new FunctionTypeDepthState(saved));
      return;
    }
    assert (!(FD != null) || FD.getNumParams() == Proto.getNumParams());
    for (/*uint*/int I = 0, E = Proto.getNumParams(); I != E; ++I) {
      // Mangle extended parameter info as order-sensitive qualifiers here.
      if (Proto.hasExtParameterInfos() && FD == null) {
        mangleExtParameterInfo(Proto.getExtParameterInfo(I));
      }
      
      // Mangle the type.
      QualType ParamTy = Proto.getParamType(I);
      mangleType(Context.getASTContext().getSignatureParameterType(new QualType(ParamTy)));
      if ((FD != null)) {
        {
          PassObjectSizeAttr /*P*/ Attr = FD.getParamDecl$Const(I).getAttr(PassObjectSizeAttr.class);
          if ((Attr != null)) {
            // Attr can only take 1 character, so we can hardcode the length below.
            assert (Attr.getType() <= 9 && Attr.getType() >= 0);
            Out.$out(/*KEEP_STR*/"U17pass_object_size").$out_int(Attr.getType());
          }
        }
      }
    }
    
    FunctionTypeDepth.pop(new FunctionTypeDepthState(saved));
    
    // <builtin-type>      ::= z  # ellipsis
    if (Proto.isVariadic()) {
      Out.$out_char($$z);
    }
  }

  
  // ARM's ABI for Neon vector types specifies that they should be mangled as
  // if they are structs (to match ARM's initial implementation).  The
  // vector type must be one of the special types predefined by ARM.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleNeonVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2721,
   FQN="(anonymous namespace)::CXXNameMangler::mangleNeonVectorType", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleNeonVectorTypeEPKN5clang10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleNeonVectorTypeEPKN5clang10VectorTypeE")
  //</editor-fold>
  private void mangleNeonVectorType(/*const*/ VectorType /*P*/ T) {
    QualType EltType = T.getElementType();
    assert (EltType.$arrow().isBuiltinType()) : "Neon vector element not a BuiltinType";
    /*const*/char$ptr/*char P*/ EltName = null;
    if (T.getVectorKind() == VectorType.VectorKind.NeonPolyVector) {
      switch (cast_BuiltinType(EltType).getKind()) {
       case SChar:
       case UChar:
        EltName = $tryClone($("poly8_t"));
        break;
       case Short:
       case UShort:
        EltName = $tryClone($("poly16_t"));
        break;
       case ULongLong:
        EltName = $tryClone($("poly64_t"));
        break;
       default:
        throw new llvm_unreachable("unexpected Neon polynomial vector element type");
      }
    } else {
      switch (cast_BuiltinType(EltType).getKind()) {
       case SChar:
        EltName = $tryClone($("int8_t"));
        break;
       case UChar:
        EltName = $tryClone($("uint8_t"));
        break;
       case Short:
        EltName = $tryClone($("int16_t"));
        break;
       case UShort:
        EltName = $tryClone($("uint16_t"));
        break;
       case Int:
        EltName = $tryClone($("int32_t"));
        break;
       case UInt:
        EltName = $tryClone($("uint32_t"));
        break;
       case LongLong:
        EltName = $tryClone($("int64_t"));
        break;
       case ULongLong:
        EltName = $tryClone($("uint64_t"));
        break;
       case Double:
        EltName = $tryClone($("float64_t"));
        break;
       case Float:
        EltName = $tryClone($("float32_t"));
        break;
       case Half:
        EltName = $tryClone($("float16_t"));
        break;
       default:
        throw new llvm_unreachable("unexpected Neon vector element type");
      }
    }
    /*const*/char$ptr/*char P*/ BaseName = null;
    /*uint*/int BitSize = $ullong2uint(($uint2ullong(T.getNumElements())
       * getASTContext().getTypeSize(new QualType(EltType))));
    if (BitSize == 64) {
      BaseName = $tryClone($("__simd64_"));
    } else {
      assert (BitSize == 128) : "Neon vector type not 64 or 128 bits";
      BaseName = $tryClone($("__simd128_"));
    }
    Out.$out_uint(strlen(BaseName) + strlen(EltName));
    Out.$out(BaseName).$out(EltName);
  }

  
  // AArch64's ABI for Neon vector types specifies that they should be mangled as
  // the equivalent internal name. The vector type must be one of the special
  // types predefined by ARM.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleAArch64NeonVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2804,
   FQN="(anonymous namespace)::CXXNameMangler::mangleAArch64NeonVectorType", NM="_ZN12_GLOBAL__N_114CXXNameMangler27mangleAArch64NeonVectorTypeEPKN5clang10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler27mangleAArch64NeonVectorTypeEPKN5clang10VectorTypeE")
  //</editor-fold>
  private void mangleAArch64NeonVectorType(/*const*/ VectorType /*P*/ T) {
    QualType EltType = T.getElementType();
    assert (EltType.$arrow().isBuiltinType()) : "Neon vector element not a BuiltinType";
    /*uint*/int BitSize = $ullong2uint(($uint2ullong(T.getNumElements()) * getASTContext().getTypeSize(new QualType(EltType))));
    ///*J:(void)*/BitSize; // Silence warning.
    assert ((BitSize == 64 || BitSize == 128)) : "Neon vector type not 64 or 128 bits";
    
    StringRef EltName/*J*/= new StringRef();
    if (T.getVectorKind() == VectorType.VectorKind.NeonPolyVector) {
      switch (cast_BuiltinType(EltType).getKind()) {
       case UChar:
        EltName.$assignMove(/*STRINGREF_STR*/"Poly8");
        break;
       case UShort:
        EltName.$assignMove(/*STRINGREF_STR*/"Poly16");
        break;
       case ULong:
       case ULongLong:
        EltName.$assignMove(/*STRINGREF_STR*/"Poly64");
        break;
       default:
        throw new llvm_unreachable("unexpected Neon polynomial vector element type");
      }
    } else {
      EltName.$assignMove(mangleAArch64VectorBase(cast_BuiltinType(EltType)));
    }
    
    std.string TypeName = (llvm.$add_Twine$C(llvm.$add_Twine$C(llvm.$add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"__", EltName), new Twine(/*KEEP_STR*/$x)), new Twine(JD$UInt.INSTANCE, T.getNumElements())), new Twine(/*KEEP_STR*/"_t"))).str();
    Out.$out_uint(TypeName.length()).$out(TypeName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3073,
   FQN="(anonymous namespace)::CXXNameMangler::mangleIntegerLiteral", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleIntegerLiteralEN5clang8QualTypeERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleIntegerLiteralEN5clang8QualTypeERKN4llvm6APSIntE")
  //</editor-fold>
  private void mangleIntegerLiteral(QualType T, 
                      final /*const*/ APSInt /*&*/ Value) {
    //  <expr-primary> ::= L <type> <value number> E # integer literal
    Out.$out_char($$L);
    
    mangleType(new QualType(T));
    if (T.$arrow().isBooleanType()) {
      // Boolean values are encoded as 0/1.
      Out.$out_char((Value.getBoolValue() ? $$1 : $$0));
    } else {
      mangleNumber(Value);
    }
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleMemberExprBase">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3089,
   FQN="(anonymous namespace)::CXXNameMangler::mangleMemberExprBase", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleMemberExprBaseEPKN5clang4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleMemberExprBaseEPKN5clang4ExprEb")
  //</editor-fold>
  private void mangleMemberExprBase(/*const*/ Expr /*P*/ Base, boolean IsArrow) {
    {
      // Ignore member expressions involving anonymous unions.
      /*const*/ RecordType /*P*/ RT;
      while (((/*const*/ /*P*/ RT = Base.getType().$arrow().getAs$RecordType()) != null)) {
        if (!RT.getDecl().isAnonymousStructOrUnion()) {
          break;
        }
        /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(Base);
        if (!(ME != null)) {
          break;
        }
        Base = ME.getBase();
        IsArrow = ME.isArrow();
      }
    }
    if (Base.isImplicitCXXThis()) {
      // Note: GCC mangles member expressions to the implicit 'this' as
      // *this., whereas we represent them as this->. The Itanium C++ ABI
      // does not specify anything here, so we follow GCC.
      Out.$out(/*KEEP_STR*/"dtdefpT");
    } else {
      Out.$out((IsArrow ? $("pt") : $("dt")));
      mangleExpression(Base);
    }
  }

  
  /// Mangles a member expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3113,
   FQN="(anonymous namespace)::CXXNameMangler::mangleMemberExpr", NM="_ZN12_GLOBAL__N_114CXXNameMangler16mangleMemberExprEPKN5clang4ExprEbPNS1_19NestedNameSpecifierEPNS1_9NamedDeclENS1_15DeclarationNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler16mangleMemberExprEPKN5clang4ExprEbPNS1_19NestedNameSpecifierEPNS1_9NamedDeclENS1_15DeclarationNameEj")
  //</editor-fold>
  private void mangleMemberExpr(/*const*/ Expr /*P*/ base, 
                  boolean isArrow, 
                  NestedNameSpecifier /*P*/ qualifier, 
                  NamedDecl /*P*/ firstQualifierLookup, 
                  DeclarationName member, 
                  /*uint*/int arity) {
    // <expression> ::= dt <expression> <unresolved-name>
    //              ::= pt <expression> <unresolved-name>
    if ((base != null)) {
      mangleMemberExprBase(base, isArrow);
    }
    mangleUnresolvedName(qualifier, new DeclarationName(member), arity);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleCastExpression">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3157,
   FQN="(anonymous namespace)::CXXNameMangler::mangleCastExpression", NM="_ZN12_GLOBAL__N_114CXXNameMangler20mangleCastExpressionEPKN5clang4ExprEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20mangleCastExpressionEPKN5clang4ExprEN4llvm9StringRefE")
  //</editor-fold>
  private void mangleCastExpression(/*const*/ Expr /*P*/ E, StringRef CastEncoding) {
    /*const*/ ExplicitCastExpr /*P*/ ECE = cast_ExplicitCastExpr(E);
    Out.$out(/*NO_COPY*/CastEncoding);
    mangleType(ECE.getType());
    mangleExpression(ECE.getSubExpr$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleInitListElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3164,
   FQN="(anonymous namespace)::CXXNameMangler::mangleInitListElements", NM="_ZN12_GLOBAL__N_114CXXNameMangler22mangleInitListElementsEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler22mangleInitListElementsEPKN5clang12InitListExprE")
  //</editor-fold>
  private void mangleInitListElements(/*const*/ InitListExpr /*P*/ InitList) {
    {
      InitListExpr /*P*/ Syntactic = InitList.getSyntacticForm();
      if ((Syntactic != null)) {
        InitList = Syntactic;
      }
    }
    for (/*uint*/int i = 0, e = InitList.getNumInits(); i != e; ++i)  {
      mangleExpression(InitList.getInit$Const(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleExpression">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3171,
   FQN="(anonymous namespace)::CXXNameMangler::mangleExpression", NM="_ZN12_GLOBAL__N_114CXXNameMangler16mangleExpressionEPKN5clang4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler16mangleExpressionEPKN5clang4ExprEj")
  //</editor-fold>
  private void mangleExpression(/*const*/ Expr /*P*/ E) {
    mangleExpression(E, UnknownArity);
  }
  private void mangleExpression(/*const*/ Expr /*P*/ E, /*uint*/int Arity/*= UnknownArity*/) {
    // <expression> ::= <unary operator-name> <expression>
    //              ::= <binary operator-name> <expression> <expression>
    //              ::= <trinary operator-name> <expression> <expression> <expression>
    //              ::= cv <type> expression           # conversion with one argument
    //              ::= cv <type> _ <expression>* E # conversion with a different number of arguments
    //              ::= dc <type> <expression>         # dynamic_cast<type> (expression)
    //              ::= sc <type> <expression>         # static_cast<type> (expression)
    //              ::= cc <type> <expression>         # const_cast<type> (expression)
    //              ::= rc <type> <expression>         # reinterpret_cast<type> (expression)
    //              ::= st <type>                      # sizeof (a type)
    //              ::= at <type>                      # alignof (a type)
    //              ::= <template-param>
    //              ::= <function-param>
    //              ::= sr <type> <unqualified-name>                   # dependent name
    //              ::= sr <type> <unqualified-name> <template-args>   # dependent template-id
    //              ::= ds <expression> <expression>                   # expr.*expr
    //              ::= sZ <template-param>                            # size of a parameter pack
    //              ::= sZ <function-param>    # size of a function parameter pack
    //              ::= <expr-primary>
    // <expr-primary> ::= L <type> <value number> E    # integer literal
    //                ::= L <type <value float> E      # floating literal
    //                ::= L <mangled-name> E           # external name
    //                ::= fpT                          # 'this' expression
    QualType ImplicitlyConvertedToType/*J*/= new QualType();
   recurse:
   do {
    switch (E.getStmtClass()) {
     case NoStmtClass:
     case GCCAsmStmtClass:
     case MSAsmStmtClass:
     case AttributedStmtClass:
     case BreakStmtClass:
     case CXXCatchStmtClass:
     case CXXForRangeStmtClass:
     case CXXTryStmtClass:
     case CapturedStmtClass:
     case CompoundStmtClass:
     case ContinueStmtClass:
     case CoreturnStmtClass:
     case CoroutineBodyStmtClass:
     case DeclStmtClass:
     case DoStmtClass:
     case ForStmtClass:
     case GotoStmtClass:
     case IfStmtClass:
     case IndirectGotoStmtClass:
     case LabelStmtClass:
     case MSDependentExistsStmtClass:
     case NullStmtClass:
     case OMPAtomicDirectiveClass:
     case OMPBarrierDirectiveClass:
     case OMPCancelDirectiveClass:
     case OMPCancellationPointDirectiveClass:
     case OMPCriticalDirectiveClass:
     case OMPFlushDirectiveClass:
     case OMPDistributeDirectiveClass:
     case OMPDistributeParallelForDirectiveClass:
     case OMPDistributeParallelForSimdDirectiveClass:
     case OMPDistributeSimdDirectiveClass:
     case OMPForDirectiveClass:
     case OMPForSimdDirectiveClass:
     case OMPParallelForDirectiveClass:
     case OMPParallelForSimdDirectiveClass:
     case OMPSimdDirectiveClass:
     case OMPTargetParallelForSimdDirectiveClass:
     case OMPTaskLoopDirectiveClass:
     case OMPTaskLoopSimdDirectiveClass:
     case OMPMasterDirectiveClass:
     case OMPOrderedDirectiveClass:
     case OMPParallelDirectiveClass:
     case OMPParallelSectionsDirectiveClass:
     case OMPSectionDirectiveClass:
     case OMPSectionsDirectiveClass:
     case OMPSingleDirectiveClass:
     case OMPTargetDataDirectiveClass:
     case OMPTargetDirectiveClass:
     case OMPTargetEnterDataDirectiveClass:
     case OMPTargetExitDataDirectiveClass:
     case OMPTargetParallelDirectiveClass:
     case OMPTargetParallelForDirectiveClass:
     case OMPTargetUpdateDirectiveClass:
     case OMPTaskDirectiveClass:
     case OMPTaskgroupDirectiveClass:
     case OMPTaskwaitDirectiveClass:
     case OMPTaskyieldDirectiveClass:
     case OMPTeamsDirectiveClass:
     case ObjCAtCatchStmtClass:
     case ObjCAtFinallyStmtClass:
     case ObjCAtSynchronizedStmtClass:
     case ObjCAtThrowStmtClass:
     case ObjCAtTryStmtClass:
     case ObjCAutoreleasePoolStmtClass:
     case ObjCForCollectionStmtClass:
     case ReturnStmtClass:
     case SEHExceptStmtClass:
     case SEHFinallyStmtClass:
     case SEHLeaveStmtClass:
     case SEHTryStmtClass:
     case CaseStmtClass:
     case DefaultStmtClass:
     case SwitchStmtClass:
     case WhileStmtClass:
     case AddrLabelExprClass:
     case DesignatedInitUpdateExprClass:
     case ImplicitValueInitExprClass:
     case NoInitExprClass:
     case ParenListExprClass:
     case LambdaExprClass:
     case MSPropertyRefExprClass:
     case MSPropertySubscriptExprClass:
     case TypoExprClass: // This should no longer exist in the AST by now.
     case OMPArraySectionExprClass:
     case CXXInheritedCtorInitExprClass:
      throw new llvm_unreachable("unexpected statement kind");
     case BlockExprClass:
     case ChooseExprClass:
     case CompoundLiteralExprClass:
     case DesignatedInitExprClass:
     case ExtVectorElementExprClass:
     case GenericSelectionExprClass:
     case ObjCEncodeExprClass:
     case ObjCIsaExprClass:
     case ObjCIvarRefExprClass:
     case ObjCMessageExprClass:
     case ObjCPropertyRefExprClass:
     case ObjCProtocolExprClass:
     case ObjCSelectorExprClass:
     case ObjCStringLiteralClass:
     case ObjCBoxedExprClass:
     case ObjCArrayLiteralClass:
     case ObjCDictionaryLiteralClass:
     case ObjCSubscriptRefExprClass:
     case ObjCIndirectCopyRestoreExprClass:
     case ObjCAvailabilityCheckExprClass:
     case OffsetOfExprClass:
     case PredefinedExprClass:
     case ShuffleVectorExprClass:
     case ConvertVectorExprClass:
     case StmtExprClass:
     case TypeTraitExprClass:
     case ArrayTypeTraitExprClass:
     case ExpressionTraitExprClass:
     case VAArgExprClass:
     case CUDAKernelCallExprClass:
     case AsTypeExprClass:
     case PseudoObjectExprClass:
     case AtomicExprClass:
      {
        if (!NullOut) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // As bad as this diagnostic is, it's better than crashing.
            final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
            /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
                /*KEEP_STR*/"cannot yet mangle expression type %0");
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(E.getExprLoc(), DiagID)), 
                    E.getStmtClassName()), E.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        break;
      }
     case CXXUuidofExprClass:
      {
        /*const*/ CXXUuidofExpr /*P*/ UE = cast_CXXUuidofExpr(E);
        if (UE.isTypeOperand()) {
          QualType UuidT = UE.getTypeOperand(Context.getASTContext());
          Out.$out(/*KEEP_STR*/"u8__uuidoft");
          mangleType(new QualType(UuidT));
        } else {
          Expr /*P*/ UuidExp = UE.getExprOperand();
          Out.$out(/*KEEP_STR*/"u8__uuidofz");
          mangleExpression(UuidExp, Arity);
        }
        break;
      }
     case BinaryConditionalOperatorClass:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
          /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
              /*KEEP_STR*/"?: operator with omitted middle operand cannot be mangled");
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(E.getExprLoc(), DiagID)), 
                  E.getStmtClassName()), E.getSourceRange()));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OpaqueValueExprClass:
      
      // These are used for internal purposes and cannot be meaningfully mangled.
      throw new llvm_unreachable("cannot mangle opaque value; mangling wrong thing?");
     case InitListExprClass:
      {
        Out.$out(/*KEEP_STR*/"il");
        mangleInitListElements(cast_InitListExpr(E));
        Out.$out(/*KEEP_STR*/$E);
        break;
      }
     case CXXDefaultArgExprClass:
      mangleExpression(cast_CXXDefaultArgExpr(E).getExpr$Const(), Arity);
      break;
     case CXXDefaultInitExprClass:
      mangleExpression(cast_CXXDefaultInitExpr(E).getExpr$Const(), Arity);
      break;
     case CXXStdInitializerListExprClass:
      mangleExpression(cast_CXXStdInitializerListExpr(E).getSubExpr$Const(), Arity);
      break;
     case SubstNonTypeTemplateParmExprClass:
      mangleExpression(cast_SubstNonTypeTemplateParmExpr(E).getReplacement(), 
          Arity);
      break;
     case UserDefinedLiteralClass:
     case CXXMemberCallExprClass: // fallthrough
     case CallExprClass:
      {
        /*const*/ CallExpr /*P*/ CE = cast_CallExpr(E);
        
        // <expression> ::= cp <simple-id> <expression>* E
        // We use this mangling only when the call would use ADL except
        // for being parenthesized.  Per discussion with David
        // Vandervoorde, 2011.04.25.
        if (isParenthesizedADLCallee(CE)) {
          Out.$out(/*KEEP_STR*/"cp");

          // The callee here is a parenthesized UnresolvedLookupExpr with
          // no qualifier and should always get mangled as a <simple-id>
          // anyway.

          // <expression> ::= cl <expression>* E
        } else {
          Out.$out(/*KEEP_STR*/"cl");
        }
        
        /*uint*/int CallArity = CE.getNumArgs();
        for (/*const*/ Expr /*P*/ Arg : CE.arguments$Const())  {
          if (isa_PackExpansionExpr(Arg)) {
            CallArity = UnknownArity;
          }
        }
        
        mangleExpression(CE.getCallee$Const(), CallArity);
        for (/*const*/ Expr /*P*/ Arg : CE.arguments$Const())  {
          mangleExpression(Arg);
        }
        Out.$out_char($$E);
        break;
      }
     case CXXNewExprClass:
      {
        /*const*/ CXXNewExpr /*P*/ New = cast_CXXNewExpr(E);
        if (New.isGlobalNew()) {
          Out.$out(/*KEEP_STR*/"gs");
        }
        Out.$out((New.isArray() ? $("na") : $("nw")));
        for (Stmt.ConstExprIterator I = New.placement_arg_begin$Const(), 
            E$1 = New.placement_arg_end$Const(); I.$noteq(E$1); I.$preInc())  {
          mangleExpression(I.$star());
        }
        Out.$out_char($$UNDERSCORE);
        mangleType(New.getAllocatedType());
        if (New.hasInitializer()) {
          if (New.getInitializationStyle() == CXXNewExpr.InitializationStyle.ListInit) {
            Out.$out(/*KEEP_STR*/"il");
          } else {
            Out.$out(/*KEEP_STR*/"pi");
          }
          /*const*/ Expr /*P*/ Init = New.getInitializer$Const();
          {
            /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(Init);
            if ((CCE != null)) {
              // Directly inline the initializers.
              for (Stmt.ConstExprIterator I = CCE.arg_begin$Const(), 
                  E$1 = CCE.arg_end$Const();
                   I.$noteq(E$1); I.$preInc())  {
                mangleExpression(I.$star());
              }
            } else {
              /*const*/ ParenListExpr /*P*/ PLE = dyn_cast_ParenListExpr(Init);
              if ((PLE != null)) {
                for (/*uint*/int i = 0, e = PLE.getNumExprs(); i != e; ++i)  {
                  mangleExpression(PLE.getExpr$Const(i));
                }
              } else if (New.getInitializationStyle() == CXXNewExpr.InitializationStyle.ListInit
                 && isa_InitListExpr(Init)) {
                // Only take InitListExprs apart for list-initialization.
                mangleInitListElements(cast_InitListExpr(Init));
              } else {
                mangleExpression(Init);
              }
            }
          }
        }
        Out.$out_char($$E);
        break;
      }
     case CXXPseudoDestructorExprClass:
      {
        /*const*/ CXXPseudoDestructorExpr /*P*/ PDE = cast_CXXPseudoDestructorExpr(E);
        {
          /*const*/ Expr /*P*/ Base = PDE.getBase();
          if ((Base != null)) {
            mangleMemberExprBase(Base, PDE.isArrow());
          }
        }
        NestedNameSpecifier /*P*/ Qualifier = PDE.getQualifier();
        QualType ScopeType/*J*/= new QualType();
        {
          TypeSourceInfo /*P*/ ScopeInfo = PDE.getScopeTypeInfo();
          if ((ScopeInfo != null)) {
            if ((Qualifier != null)) {
              mangleUnresolvedPrefix(Qualifier, 
                  /*Recursive=*/ true);
              mangleUnresolvedTypeOrSimpleId(ScopeInfo.getType());
              Out.$out_char($$E);
            } else {
              Out.$out(/*KEEP_STR*/"sr");
              if (!mangleUnresolvedTypeOrSimpleId(ScopeInfo.getType())) {
                Out.$out_char($$E);
              }
            }
          } else if ((Qualifier != null)) {
            mangleUnresolvedPrefix(Qualifier);
          }
        }
        // <base-unresolved-name> ::= dn <destructor-name>
        Out.$out(/*KEEP_STR*/"dn");
        QualType DestroyedType = PDE.getDestroyedType();
        mangleUnresolvedTypeOrSimpleId(new QualType(DestroyedType));
        break;
      }
     case MemberExprClass:
      {
        /*const*/ MemberExpr /*P*/ ME = cast_MemberExpr(E);
        mangleMemberExpr(ME.getBase(), ME.isArrow(), 
            ME.getQualifier(), (NamedDecl /*P*/ )null, 
            ME.getMemberDecl().getDeclName(), Arity);
        break;
      }
     case UnresolvedMemberExprClass:
      {
        /*const*/ UnresolvedMemberExpr /*P*/ ME = cast_UnresolvedMemberExpr(E);
        mangleMemberExpr(ME.isImplicitAccess() ? (/*const*/ Expr /*P*/ )null : ME.getBase$Const(), 
            ME.isArrow(), ME.getQualifier(), (NamedDecl /*P*/ )null, 
            ME.getMemberName(), Arity);
        if (ME.hasExplicitTemplateArgs()) {
          mangleTemplateArgLocs(ME.getTemplateArgs(), ME.getNumTemplateArgs());
        }
        break;
      }
     case CXXDependentScopeMemberExprClass:
      {
        /*const*/ CXXDependentScopeMemberExpr /*P*/ ME = cast_CXXDependentScopeMemberExpr(E);
        mangleMemberExpr(ME.isImplicitAccess() ? (Expr /*P*/ )null : ME.getBase(), 
            ME.isArrow(), ME.getQualifier(), 
            ME.getFirstQualifierFoundInScope(), 
            ME.getMember(), Arity);
        if (ME.hasExplicitTemplateArgs()) {
          mangleTemplateArgLocs(ME.getTemplateArgs(), ME.getNumTemplateArgs());
        }
        break;
      }
     case UnresolvedLookupExprClass:
      {
        /*const*/ UnresolvedLookupExpr /*P*/ ULE = cast_UnresolvedLookupExpr(E);
        mangleUnresolvedName(ULE.getQualifier(), ULE.getName(), Arity);
        
        // All the <unresolved-name> productions end in a
        // base-unresolved-name, where <template-args> are just tacked
        // onto the end.
        if (ULE.hasExplicitTemplateArgs()) {
          mangleTemplateArgLocs(ULE.getTemplateArgs(), ULE.getNumTemplateArgs());
        }
        break;
      }
     case CXXUnresolvedConstructExprClass:
      {
        /*const*/ CXXUnresolvedConstructExpr /*P*/ CE = cast_CXXUnresolvedConstructExpr(E);
        /*uint*/int N = CE.arg_size();
        
        Out.$out(/*KEEP_STR*/"cv");
        mangleType(CE.getType());
        if (N != 1) {
          Out.$out_char($$UNDERSCORE);
        }
        for (/*uint*/int I = 0; I != N; ++I)  {
          mangleExpression(CE.getArg$Const(I));
        }
        if (N != 1) {
          Out.$out_char($$E);
        }
        break;
      }
     case CXXConstructExprClass:
      {
        /*const*/ CXXConstructExpr /*P*/ CE = cast_CXXConstructExpr(E);
        if (!CE.isListInitialization() || CE.isStdInitListInitialization()) {
          assert ($greatereq_uint(CE.getNumArgs(), 1) && (CE.getNumArgs() == 1 || isa_CXXDefaultArgExpr(CE.getArg$Const(1)))) : "implicit CXXConstructExpr must have one argument";
          mangleExpression(cast_CXXConstructExpr(E).getArg$Const(0));
          /*JAVA:return*/return;
        }
        Out.$out(/*KEEP_STR*/"il");
        for (/*const*/ Expr /*P*/ E$1 : CE.arguments$Const())  {
          mangleExpression(E$1);
        }
        Out.$out(/*KEEP_STR*/$E);
        break;
      }
     case CXXTemporaryObjectExprClass:
      {
        /*const*/ CXXTemporaryObjectExpr /*P*/ CE = cast_CXXTemporaryObjectExpr(E);
        /*uint*/int N = CE.getNumArgs();
        boolean List = CE.isListInitialization();
        if (List) {
          Out.$out(/*KEEP_STR*/"tl");
        } else {
          Out.$out(/*KEEP_STR*/"cv");
        }
        mangleType(CE.getType());
        if (!List && N != 1) {
          Out.$out_char($$UNDERSCORE);
        }
        if (CE.isStdInitListInitialization()) {
          // We implicitly created a std::initializer_list<T> for the first argument
          // of a constructor of type U in an expression of the form U{a, b, c}.
          // Strip all the semantic gunk off the initializer list.
          /*const*/ CXXStdInitializerListExpr /*P*/ SILE = cast_CXXStdInitializerListExpr(CE.getArg$Const(0).IgnoreImplicit$Const());
          /*const*/ InitListExpr /*P*/ ILE = cast_InitListExpr(SILE.getSubExpr$Const().IgnoreImplicit$Const());
          mangleInitListElements(ILE);
        } else {
          for (/*const*/ Expr /*P*/ E$1 : CE.arguments$Const())  {
            mangleExpression(E$1);
          }
        }
        if (List || N != 1) {
          Out.$out_char($$E);
        }
        break;
      }
     case CXXScalarValueInitExprClass:
      Out.$out(/*KEEP_STR*/"cv");
      mangleType(E.getType());
      Out.$out(/*KEEP_STR*/"_E");
      break;
     case CXXNoexceptExprClass:
      Out.$out(/*KEEP_STR*/"nx");
      mangleExpression(cast_CXXNoexceptExpr(E).getOperand());
      break;
     case UnaryExprOrTypeTraitExprClass:
      {
        /*const*/ UnaryExprOrTypeTraitExpr /*P*/ SAE = cast_UnaryExprOrTypeTraitExpr(E);
        if (!SAE.isInstantiationDependent()) {
          // Itanium C++ ABI:
          //   If the operand of a sizeof or alignof operator is not 
          //   instantiation-dependent it is encoded as an integer literal 
          //   reflecting the result of the operator.
          //
          //   If the result of the operator is implicitly converted to a known 
          //   integer type, that type is used for the literal; otherwise, the type 
          //   of std::size_t or std::ptrdiff_t is used.
          QualType T = (ImplicitlyConvertedToType.isNull()
             || !ImplicitlyConvertedToType.$arrow().isIntegerType()) ? SAE.getType() : new QualType(ImplicitlyConvertedToType);
          APSInt V = SAE.EvaluateKnownConstInt(Context.getASTContext());
          mangleIntegerLiteral(new QualType(T), V);
          break;
        }
        switch (SAE.getKind()) {
         case UETT_SizeOf:
          Out.$out_char($$s);
          break;
         case UETT_AlignOf:
          Out.$out_char($$a);
          break;
         case UETT_VecStep:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
              /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
                  /*KEEP_STR*/"cannot yet mangle vec_step expression");
              $c$.clean($c$.track(Diags.Report(DiagID)));
              return;
            } finally {
              $c$.$destroy();
            }
          }
         case UETT_OpenMPRequiredSimdAlign:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              final DiagnosticsEngine /*&*/ Diags = Context.getDiags();
              /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
                  /*KEEP_STR*/"cannot yet mangle __builtin_omp_required_simd_align expression");
              $c$.clean($c$.track(Diags.Report(DiagID)));
              return;
            } finally {
              $c$.$destroy();
            }
          }
        }
        if (SAE.isArgumentType()) {
          Out.$out_char($$t);
          mangleType(SAE.getArgumentType());
        } else {
          Out.$out_char($$z);
          mangleExpression(SAE.getArgumentExpr$Const());
        }
        break;
      }
     case CXXThrowExprClass:
      {
        /*const*/ CXXThrowExpr /*P*/ TE = cast_CXXThrowExpr(E);
        //  <expression> ::= tw <expression>  # throw expression
        //               ::= tr               # rethrow
        if ((TE.getSubExpr$Const() != null)) {
          Out.$out(/*KEEP_STR*/"tw");
          mangleExpression(TE.getSubExpr$Const());
        } else {
          Out.$out(/*KEEP_STR*/"tr");
        }
        break;
      }
     case CXXTypeidExprClass:
      {
        /*const*/ CXXTypeidExpr /*P*/ TIE = cast_CXXTypeidExpr(E);
        //  <expression> ::= ti <type>        # typeid (type)
        //               ::= te <expression>  # typeid (expression)
        if (TIE.isTypeOperand()) {
          Out.$out(/*KEEP_STR*/"ti");
          mangleType(TIE.getTypeOperand(Context.getASTContext()));
        } else {
          Out.$out(/*KEEP_STR*/"te");
          mangleExpression(TIE.getExprOperand());
        }
        break;
      }
     case CXXDeleteExprClass:
      {
        /*const*/ CXXDeleteExpr /*P*/ DE = cast_CXXDeleteExpr(E);
        //  <expression> ::= [gs] dl <expression>  # [::] delete expr
        //               ::= [gs] da <expression>  # [::] delete [] expr
        if (DE.isGlobalDelete()) {
          Out.$out(/*KEEP_STR*/"gs");
        }
        Out.$out((DE.isArrayForm() ? $("da") : $("dl")));
        mangleExpression(DE.getArgument$Const());
        break;
      }
     case UnaryOperatorClass:
      {
        /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(E);
        mangleOperatorName(UnaryOperator.getOverloadedOperator(UO.getOpcode()), 
            /*Arity=*/ 1);
        mangleExpression(UO.getSubExpr());
        break;
      }
     case ArraySubscriptExprClass:
      {
        /*const*/ ArraySubscriptExpr /*P*/ AE = cast_ArraySubscriptExpr(E);
        
        // Array subscript is treated as a syntactically weird form of
        // binary operator.
        Out.$out(/*KEEP_STR*/"ix");
        mangleExpression(AE.getLHS$Const());
        mangleExpression(AE.getRHS$Const());
        break;
      }
     case CompoundAssignOperatorClass: // fallthrough
     case BinaryOperatorClass:
      {
        /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(E);
        if (BO.getOpcode() == BinaryOperatorKind.BO_PtrMemD) {
          Out.$out(/*KEEP_STR*/"ds");
        } else {
          mangleOperatorName(BinaryOperator.getOverloadedOperator(BO.getOpcode()), 
              /*Arity=*/ 2);
        }
        mangleExpression(BO.getLHS());
        mangleExpression(BO.getRHS());
        break;
      }
     case ConditionalOperatorClass:
      {
        /*const*/ ConditionalOperator /*P*/ CO = cast_ConditionalOperator(E);
        mangleOperatorName(OverloadedOperatorKind.OO_Conditional, /*Arity=*/ 3);
        mangleExpression(CO.getCond());
        mangleExpression(CO.getLHS(), Arity);
        mangleExpression(CO.getRHS(), Arity);
        break;
      }
     case ImplicitCastExprClass:
      {
        ImplicitlyConvertedToType.$assignMove(E.getType());
        E = cast_ImplicitCastExpr(E).getSubExpr$Const();
        continue recurse;
      }
     case ObjCBridgedCastExprClass:
      {
        // Mangle ownership casts as a vendor extended operator __bridge, 
        // __bridge_transfer, or __bridge_retain.
        StringRef Kind = cast_ObjCBridgedCastExpr(E).getBridgeKindName();
        Out.$out(/*KEEP_STR*/"v1U").$out_uint(Kind.size()).$out(/*NO_COPY*/Kind);
      }
     case CStyleCastExprClass:
      // Fall through to mangle the cast itself.
      mangleCastExpression(E, new StringRef(/*KEEP_STR*/"cv"));
      break;
     case CXXFunctionalCastExprClass:
      {
        /*const*/ Expr /*P*/ Sub = cast_ExplicitCastExpr(E).getSubExpr$Const().IgnoreImplicit$Const();
        {
          // FIXME: Add isImplicit to CXXConstructExpr.
          /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(Sub);
          if ((CCE != null)) {
            if (CCE.getParenOrBraceRange().isInvalid()) {
              Sub = CCE.getArg$Const(0).IgnoreImplicit$Const();
            }
          }
        }
        {
          /*const*/ CXXStdInitializerListExpr /*P*/ StdInitList = dyn_cast_CXXStdInitializerListExpr(Sub);
          if ((StdInitList != null)) {
            Sub = StdInitList.getSubExpr$Const().IgnoreImplicit$Const();
          }
        }
        {
          /*const*/ InitListExpr /*P*/ IL = dyn_cast_InitListExpr(Sub);
          if ((IL != null)) {
            Out.$out(/*KEEP_STR*/"tl");
            mangleType(E.getType());
            mangleInitListElements(IL);
            Out.$out(/*KEEP_STR*/$E);
          } else {
            mangleCastExpression(E, new StringRef(/*KEEP_STR*/"cv"));
          }
        }
        break;
      }
     case CXXStaticCastExprClass:
      mangleCastExpression(E, new StringRef(/*KEEP_STR*/"sc"));
      break;
     case CXXDynamicCastExprClass:
      mangleCastExpression(E, new StringRef(/*KEEP_STR*/"dc"));
      break;
     case CXXReinterpretCastExprClass:
      mangleCastExpression(E, new StringRef(/*KEEP_STR*/"rc"));
      break;
     case CXXConstCastExprClass:
      mangleCastExpression(E, new StringRef(/*KEEP_STR*/"cc"));
      break;
     case CXXOperatorCallExprClass:
      {
        /*const*/ CXXOperatorCallExpr /*P*/ CE = cast_CXXOperatorCallExpr(E);
        /*uint*/int NumArgs = CE.getNumArgs();
        mangleOperatorName(CE.getOperator(), /*Arity=*/ NumArgs);
        // Mangle the arguments.
        for (/*uint*/int i = 0; i != NumArgs; ++i)  {
          mangleExpression(CE.getArg$Const(i));
        }
        break;
      }
     case ParenExprClass:
      mangleExpression(cast_ParenExpr(E).getSubExpr$Const(), Arity);
      break;
     case DeclRefExprClass:
      {
        /*const*/ NamedDecl /*P*/ D = cast_DeclRefExpr(E).getDecl$Const();
        switch (D.getKind()) {
         default:
          //  <expr-primary> ::= L <mangled-name> E # external name
          Out.$out_char($$L);
          mangle(D);
          Out.$out_char($$E);
          break;
         case ParmVar:
          mangleFunctionParam(cast_ParmVarDecl(D));
          break;
         case EnumConstant:
          {
            /*const*/ EnumConstantDecl /*P*/ ED = cast_EnumConstantDecl(D);
            mangleIntegerLiteral(ED.getType(), ED.getInitVal());
            break;
          }
         case NonTypeTemplateParm:
          {
            /*const*/ NonTypeTemplateParmDecl /*P*/ PD = cast_NonTypeTemplateParmDecl(D);
            mangleTemplateParameter(PD.getIndex());
            break;
          }
        }
        
        break;
      }
     case SubstNonTypeTemplateParmPackExprClass:
      // FIXME: not clear how to mangle this!
      // template <unsigned N...> class A {
      //   template <class U...> void foo(U (&x)[N]...);
      // };
      Out.$out(/*KEEP_STR*/"_SUBSTPACK_");
      break;
     case FunctionParmPackExprClass:
      {
        // FIXME: not clear how to mangle this!
        /*const*/ FunctionParmPackExpr /*P*/ FPPE = cast_FunctionParmPackExpr(E);
        Out.$out(/*KEEP_STR*/"v110_SUBSTPACK");
        mangleFunctionParam(FPPE.getParameterPack());
        break;
      }
     case DependentScopeDeclRefExprClass:
      {
        /*const*/ DependentScopeDeclRefExpr /*P*/ DRE = cast_DependentScopeDeclRefExpr(E);
        mangleUnresolvedName(DRE.getQualifier(), DRE.getDeclName(), Arity);
        
        // All the <unresolved-name> productions end in a
        // base-unresolved-name, where <template-args> are just tacked
        // onto the end.
        if (DRE.hasExplicitTemplateArgs()) {
          mangleTemplateArgLocs(DRE.getTemplateArgs(), DRE.getNumTemplateArgs());
        }
        break;
      }
     case CXXBindTemporaryExprClass:
      mangleExpression(cast_CXXBindTemporaryExpr(E).getSubExpr$Const());
      break;
     case ExprWithCleanupsClass:
      mangleExpression(cast_ExprWithCleanups(E).getSubExpr$Const(), Arity);
      break;
     case FloatingLiteralClass:
      {
        /*const*/ FloatingLiteral /*P*/ FL = cast_FloatingLiteral(E);
        Out.$out_char($$L);
        mangleType(FL.getType());
        mangleFloat(FL.getValue());
        Out.$out_char($$E);
        break;
      }
     case CharacterLiteralClass:
      Out.$out_char($$L);
      mangleType(E.getType());
      Out.$out_uint(cast_CharacterLiteral(E).getValue());
      Out.$out_char($$E);
      break;
     case ObjCBoolLiteralExprClass:
      
      // FIXME. __objc_yes/__objc_no are mangled same as true/false
      Out.$out(/*KEEP_STR*/"Lb");
      Out.$out_char((cast_ObjCBoolLiteralExpr(E).getValue() ? $$1 : $$0));
      Out.$out_char($$E);
      break;
     case CXXBoolLiteralExprClass:
      Out.$out(/*KEEP_STR*/"Lb");
      Out.$out_char((cast_CXXBoolLiteralExpr(E).getValue() ? $$1 : $$0));
      Out.$out_char($$E);
      break;
     case IntegerLiteralClass:
      {
        APSInt Value/*J*/= new APSInt(cast_IntegerLiteral(E).getValue());
        if (E.getType().$arrow().isSignedIntegerType()) {
          Value.setIsSigned(true);
        }
        mangleIntegerLiteral(E.getType(), Value);
        break;
      }
     case ImaginaryLiteralClass:
      {
        /*const*/ ImaginaryLiteral /*P*/ IE = cast_ImaginaryLiteral(E);
        // Mangle as if a complex literal.
        // Proposal from David Vandevoorde, 2010.06.30.
        Out.$out_char($$L);
        mangleType(E.getType());
        {
          /*const*/ FloatingLiteral /*P*/ Imag = dyn_cast_FloatingLiteral(IE.getSubExpr$Const());
          if ((Imag != null)) {
            // Mangle a floating-point zero of the appropriate type.
            mangleFloat(new APFloat(Imag.getValue().getSemantics()));
            Out.$out_char($$UNDERSCORE);
            mangleFloat(Imag.getValue());
          } else {
            Out.$out(/*KEEP_STR*/"0_");
            APSInt Value/*J*/= new APSInt(cast_IntegerLiteral(IE.getSubExpr$Const()).getValue());
            if (IE.getSubExpr$Const().getType().$arrow().isSignedIntegerType()) {
              Value.setIsSigned(true);
            }
            mangleNumber(Value);
          }
        }
        Out.$out_char($$E);
        break;
      }
     case StringLiteralClass:
      {
        // Revised proposal from David Vandervoorde, 2010.07.15.
        Out.$out_char($$L);
        assert (isa_ConstantArrayType(E.getType()));
        mangleType(E.getType());
        Out.$out_char($$E);
        break;
      }
     case GNUNullExprClass:
     case CXXNullPtrLiteralExprClass:
      {
        Out.$out(/*KEEP_STR*/"LDnE");
        break;
      }
     case PackExpansionExprClass:
      Out.$out(/*KEEP_STR*/"sp");
      mangleExpression(cast_PackExpansionExpr(E).getPattern$Const());
      break;
     case SizeOfPackExprClass:
      {
        /*const*/ SizeOfPackExpr /*P*/ SPE = cast_SizeOfPackExpr(E);
        if (SPE.isPartiallySubstituted()) {
          Out.$out(/*KEEP_STR*/"sP");
          for (final /*const*/ TemplateArgument /*&*/ A : SPE.getPartialArguments())  {
            mangleTemplateArg(new TemplateArgument(A));
          }
          Out.$out(/*KEEP_STR*/$E);
          break;
        }
        
        Out.$out(/*KEEP_STR*/"sZ");
        /*const*/ NamedDecl /*P*/ Pack = SPE.getPack();
        {
          /*const*/ TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(Pack);
          if ((TTP != null)) {
            mangleTemplateParameter(TTP.getIndex());
          } else {
            /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Pack);
            if ((NTTP != null)) {
              mangleTemplateParameter(NTTP.getIndex());
            } else {
              /*const*/ TemplateTemplateParmDecl /*P*/ TempTP = dyn_cast_TemplateTemplateParmDecl(Pack);
              if ((TempTP != null)) {
                mangleTemplateParameter(TempTP.getIndex());
              } else {
                mangleFunctionParam(cast_ParmVarDecl(Pack));
              }
            }
          }
        }
        break;
      }
     case MaterializeTemporaryExprClass:
      {
        mangleExpression(cast_MaterializeTemporaryExpr(E).GetTemporaryExpr());
        break;
      }
     case CXXFoldExprClass:
      {
        /*const*/ CXXFoldExpr /*P*/ FE = cast_CXXFoldExpr(E);
        if (FE.isLeftFold()) {
          Out.$out(((FE.getInit() != null) ? $("fL") : $("fl")));
        } else {
          Out.$out(((FE.getInit() != null) ? $("fR") : $("fr")));
        }
        if (FE.getOperator() == BinaryOperatorKind.BO_PtrMemD) {
          Out.$out(/*KEEP_STR*/"ds");
        } else {
          mangleOperatorName(BinaryOperator.getOverloadedOperator(FE.getOperator()), 
              /*Arity=*/ 2);
        }
        if ((FE.getLHS() != null)) {
          mangleExpression(FE.getLHS());
        }
        if ((FE.getRHS() != null)) {
          mangleExpression(FE.getRHS());
        }
        break;
      }
     case CXXThisExprClass:
      Out.$out(/*KEEP_STR*/"fpT");
      break;
     case CoawaitExprClass:
      // FIXME: Propose a non-vendor mangling.
      Out.$out(/*KEEP_STR*/"v18co_await");
      mangleExpression(cast_CoawaitExpr(E).getOperand());
      break;
     case CoyieldExprClass:
      // FIXME: Propose a non-vendor mangling.
      Out.$out(/*KEEP_STR*/"v18co_yield");
      mangleExpression(cast_CoawaitExpr(E).getOperand());
      break;
    }
   } while (false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleCXXCtorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4002,
   FQN="(anonymous namespace)::CXXNameMangler::mangleCXXCtorType", NM="_ZN12_GLOBAL__N_114CXXNameMangler17mangleCXXCtorTypeEN5clang11CXXCtorTypeEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler17mangleCXXCtorTypeEN5clang11CXXCtorTypeEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  private void mangleCXXCtorType(CXXCtorType T, 
                   /*const*/ CXXRecordDecl /*P*/ InheritedFrom) {
    // <ctor-dtor-name> ::= C1  # complete object constructor
    //                  ::= C2  # base object constructor
    //                  ::= CI1 <type> # complete inheriting constructor
    //                  ::= CI2 <type> # base inheriting constructor
    //
    // In addition, C5 is a comdat name with C1 and C2 in it.
    Out.$out_char($$C);
    if ((InheritedFrom != null)) {
      Out.$out_char($$I);
    }
    switch (T) {
     case Ctor_Complete:
      Out.$out_char($$1);
      break;
     case Ctor_Base:
      Out.$out_char($$2);
      break;
     case Ctor_Comdat:
      Out.$out_char($$5);
      break;
     case Ctor_DefaultClosure:
     case Ctor_CopyingClosure:
      throw new llvm_unreachable("closure constructors don't exist for the Itanium ABI!");
    }
    if ((InheritedFrom != null)) {
      mangleName(InheritedFrom);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleCXXDtorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4031,
   FQN="(anonymous namespace)::CXXNameMangler::mangleCXXDtorType", NM="_ZN12_GLOBAL__N_114CXXNameMangler17mangleCXXDtorTypeEN5clang11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler17mangleCXXDtorTypeEN5clang11CXXDtorTypeE")
  //</editor-fold>
  private void mangleCXXDtorType(CXXDtorType T) {
    // <ctor-dtor-name> ::= D0  # deleting destructor
    //                  ::= D1  # complete object destructor
    //                  ::= D2  # base object destructor
    //
    // In addition, D5 is a comdat name with D1, D2 and, if virtual, D0 in it.
    switch (T) {
     case Dtor_Deleting:
      Out.$out(/*KEEP_STR*/"D0");
      break;
     case Dtor_Complete:
      Out.$out(/*KEEP_STR*/"D1");
      break;
     case Dtor_Base:
      Out.$out(/*KEEP_STR*/"D2");
      break;
     case Dtor_Comdat:
      Out.$out(/*KEEP_STR*/"D5");
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4053,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplateArgs", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateArgsEPKN5clang19TemplateArgumentLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateArgsEPKN5clang19TemplateArgumentLocEj")
  //</editor-fold>
  private void mangleTemplateArgLocs(/*const*/type$ptr<TemplateArgumentLoc/*P*/> TemplateArgs, 
                    /*uint*/int NumTemplateArgs) {
    // <template-args> ::= I <template-arg>+ E
    Out.$out_char($$I);
    for (/*uint*/int i = 0; i != NumTemplateArgs; ++i)  {
      mangleTemplateArg(new TemplateArgument(TemplateArgs.$at(i).getArgument()));
    }
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4070,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplateArgs", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateArgsEPKN5clang16TemplateArgumentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateArgsEPKN5clang16TemplateArgumentEj")
  //</editor-fold>
  private void mangleTemplateArgs(/*const*/type$ptr<TemplateArgument/*P*/> TemplateArgs, 
                    /*uint*/int NumTemplateArgs) {
    // <template-args> ::= I <template-arg>+ E
    Out.$out_char($$I);
    for (/*uint*/int i = 0; i != NumTemplateArgs; ++i)  {
      mangleTemplateArg(new TemplateArgument(TemplateArgs.$at(i)));
    }
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplateArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4062,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplateArgs", NM="_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateArgsERKN5clang20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler18mangleTemplateArgsERKN5clang20TemplateArgumentListE")
  //</editor-fold>
  private void mangleTemplateArgs(final /*const*/ TemplateArgumentList /*&*/ AL) {
    // <template-args> ::= I <template-arg>+ E
    Out.$out_char($$I);
    for (/*uint*/int i = 0, e = AL.size(); i != e; ++i)  {
      mangleTemplateArg(new TemplateArgument(AL.$at(i)));
    }
    Out.$out_char($$E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplateArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4079,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplateArg", NM="_ZN12_GLOBAL__N_114CXXNameMangler17mangleTemplateArgEN5clang16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler17mangleTemplateArgEN5clang16TemplateArgumentE")
  //</editor-fold>
  private void mangleTemplateArg(TemplateArgument A) {
    // <template-arg> ::= <type>              # type or template
    //                ::= X <expression> E    # expression
    //                ::= <expr-primary>      # simple expressions
    //                ::= J <template-arg>* E # argument pack
    if (!A.isInstantiationDependent() || A.isDependent()) {
      A.$assignMove(Context.getASTContext().getCanonicalTemplateArgument(A));
    }
    switch (A.getKind()) {
     case Null:
      throw new llvm_unreachable("Cannot mangle NULL template argument");
     case Type:
      mangleType(A.getAsType());
      break;
     case Template:
      // This is mangled as <type>.
      mangleType(A.getAsTemplate());
      break;
     case TemplateExpansion:
      // <type>  ::= Dp <type>          # pack expansion (C++0x)
      Out.$out(/*KEEP_STR*/"Dp");
      mangleType(A.getAsTemplateOrTemplatePattern());
      break;
     case Expression:
      {
        // It's possible to end up with a DeclRefExpr here in certain
        // dependent cases, in which case we should mangle as a
        // declaration.
        /*const*/ Expr /*P*/ E = A.getAsExpr().IgnoreParens();
        {
          /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
          if ((DRE != null)) {
            /*const*/ ValueDecl /*P*/ D = DRE.getDecl$Const();
            if (isa_VarDecl(D) || isa_FunctionDecl(D)) {
              Out.$out_char($$L);
              mangle(D);
              Out.$out_char($$E);
              break;
            }
          }
        }
        
        Out.$out_char($$X);
        mangleExpression(E);
        Out.$out_char($$E);
        break;
      }
     case Integral:
      mangleIntegerLiteral(A.getIntegralType(), A.getAsIntegral());
      break;
     case Declaration:
      {
        //  <expr-primary> ::= L <mangled-name> E # external name
        // Clang produces AST's where pointer-to-member-function expressions
        // and pointer-to-function expressions are represented as a declaration not
        // an expression. We compensate for it here to produce the correct mangling.
        ValueDecl /*P*/ D = A.getAsDecl();
        boolean compensateMangling = !A.getParamTypeForDecl().$arrow().isReferenceType();
        if (compensateMangling) {
          Out.$out_char($$X);
          mangleOperatorName(OverloadedOperatorKind.OO_Amp, 1);
        }
        
        Out.$out_char($$L);
        // References to external entities use the mangled name; if the name would
        // not normally be mangled then mangle it as unqualified.
        mangle(D);
        Out.$out_char($$E);
        if (compensateMangling) {
          Out.$out_char($$E);
        }
        
        break;
      }
     case NullPtr:
      {
        //  <expr-primary> ::= L <type> 0 E
        Out.$out_char($$L);
        mangleType(A.getNullPtrType());
        Out.$out(/*KEEP_STR*/"0E");
        break;
      }
     case Pack:
      {
        //  <template-arg> ::= J <template-arg>* E
        Out.$out_char($$J);
        for (final /*const*/ TemplateArgument /*&*/ P : A.pack_elements())  {
          mangleTemplateArg(new TemplateArgument(P));
        }
        Out.$out_char($$E);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleTemplateParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4166,
   FQN="(anonymous namespace)::CXXNameMangler::mangleTemplateParameter", NM="_ZN12_GLOBAL__N_114CXXNameMangler23mangleTemplateParameterEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler23mangleTemplateParameterEj")
  //</editor-fold>
  private void mangleTemplateParameter(/*uint*/int Index) {
    // <template-param> ::= T_    # first template parameter
    //                  ::= T <parameter-2 non-negative number> _
    if (Index == 0) {
      Out.$out(/*KEEP_STR*/"T_");
    } else {
      Out.$out_char($$T).$out_uint((Index - 1)).$out_char($$UNDERSCORE);
    }
  }

  
  
  /// Mangle an expression which refers to a parameter variable.
  ///
  /// <expression>     ::= <function-param>
  /// <function-param> ::= fp <top-level CV-qualifiers> _      # L == 0, I == 0
  /// <function-param> ::= fp <top-level CV-qualifiers>
  ///                      <parameter-2 non-negative number> _ # L == 0, I > 0
  /// <function-param> ::= fL <L-1 non-negative number>
  ///                      p <top-level CV-qualifiers> _       # L > 0, I == 0
  /// <function-param> ::= fL <L-1 non-negative number>
  ///                      p <top-level CV-qualifiers>
  ///                      <I-1 non-negative number> _         # L > 0, I > 0
  ///
  /// L is the nesting depth of the parameter, defined as 1 if the
  /// parameter comes from the innermost function prototype scope
  /// enclosing the current context, 2 if from the next enclosing
  /// function prototype scope, and so on, with one special case: if
  /// we've processed the full parameter clause for the innermost
  /// function type, then L is one less.  This definition conveniently
  /// makes it irrelevant whether a function's result type was written
  /// trailing or leading, but is otherwise overly complicated; the
  /// numbering was first designed without considering references to
  /// parameter in locations other than return types, and then the
  /// mangling had to be generalized without changing the existing
  /// manglings.
  ///
  /// I is the zero-based index of the parameter within its parameter
  /// declaration clause.  Note that the original ABI document describes
  /// this using 1-based ordinals.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::mangleFunctionParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3969,
   FQN="(anonymous namespace)::CXXNameMangler::mangleFunctionParam", NM="_ZN12_GLOBAL__N_114CXXNameMangler19mangleFunctionParamEPKN5clang11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler19mangleFunctionParamEPKN5clang11ParmVarDeclE")
  //</editor-fold>
  private void mangleFunctionParam(/*const*/ ParmVarDecl /*P*/ parm) {
    /*uint*/int parmDepth = parm.getFunctionScopeDepth();
    /*uint*/int parmIndex = parm.getFunctionScopeIndex();
    
    // Compute 'L'.
    // parmDepth does not include the declaring function prototype.
    // FunctionTypeDepth does account for that.
    assert ($less_uint(parmDepth, FunctionTypeDepth.getDepth()));
    /*uint*/int nestingDepth = FunctionTypeDepth.getDepth() - parmDepth;
    if (FunctionTypeDepth.isInResultType()) {
      nestingDepth--;
    }
    if (nestingDepth == 0) {
      Out.$out(/*KEEP_STR*/"fp");
    } else {
      Out.$out(/*KEEP_STR*/"fL").$out_uint((nestingDepth - 1)).$out_char($$p);
    }
    
    // Top-level qualifiers.  We don't have to worry about arrays here,
    // because parameters declared as arrays should already have been
    // transformed to have pointer type. FIXME: apparently these don't
    // get mangled if used as an rvalue of a known non-class type?
    assert (!parm.getType().$arrow().isArrayType()) : "parameter's type is still an array type?";
    mangleQualifiers(parm.getType().getQualifiers());
    
    // Parameter index.
    if (parmIndex != 0) {
      Out.$out_uint((parmIndex - 1));
    }
    Out.$out_char($$UNDERSCORE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::writeAbiTags">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 616,
   FQN="(anonymous namespace)::CXXNameMangler::writeAbiTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler12writeAbiTagsEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler12writeAbiTagsEPKN5clang9NamedDeclEPKN4llvm11SmallVectorINS5_9StringRefELj4EEE")
  //</editor-fold>
  private void writeAbiTags(/*const*/ NamedDecl /*P*/ ND, 
              /*const*/SmallVector<StringRef> /*P*/ AdditionalAbiTags) {
    assert ((AbiTags != null)) : "require AbiTagState";
    AbiTags.$star().write(Out, ND, DisableDerivedAbiTags ? (/*const*/SmallVector<StringRef> /*P*/)null : AdditionalAbiTags);
  }

  
  // Returns sorted unique list of ABI tags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::makeFunctionReturnTypeTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4409,
   FQN="(anonymous namespace)::CXXNameMangler::makeFunctionReturnTypeTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler26makeFunctionReturnTypeTagsEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler26makeFunctionReturnTypeTagsEPKN5clang12FunctionDeclE")
  //</editor-fold>
  private SmallVector<StringRef> makeFunctionReturnTypeTags(/*const*/ FunctionDecl /*P*/ FD) {
    raw_null_ostream NullOutStream = null;
    CXXNameMangler TrackReturnTypeTags = null;
    try {
      // When derived abi tags are disabled there is no need to make any list.
      if (DisableDerivedAbiTags) {
        return new SmallVector<StringRef>(4, new StringRef());
      }
      
      NullOutStream/*J*/= new raw_null_ostream();
      TrackReturnTypeTags/*J*/= new CXXNameMangler(/*Deref*/this, NullOutStream);
      TrackReturnTypeTags.disableDerivedAbiTags();
      
      /*const*/ FunctionProtoType /*P*/ Proto = cast_FunctionProtoType(FD.getType().$arrow().getAs(FunctionType.class));
      TrackReturnTypeTags.FunctionTypeDepth.enterResultType();
      TrackReturnTypeTags.mangleType(Proto.getReturnType());
      TrackReturnTypeTags.FunctionTypeDepth.leaveResultType();
      
      return new SmallVector<StringRef>(TrackReturnTypeTags.AbiTagsRoot.getSortedUniqueUsedAbiTags());
    } finally {
      if (TrackReturnTypeTags != null) { TrackReturnTypeTags.$destroy(); }
      if (NullOutStream != null) { NullOutStream.$destroy(); }
    }
  }

  // Returns sorted unique list of ABI tags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::makeVariableTypeTags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4428,
   FQN="(anonymous namespace)::CXXNameMangler::makeVariableTypeTags", NM="_ZN12_GLOBAL__N_114CXXNameMangler20makeVariableTypeTagsEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameMangler20makeVariableTypeTagsEPKN5clang7VarDeclE")
  //</editor-fold>
  private SmallVector<StringRef> makeVariableTypeTags(/*const*/ VarDecl /*P*/ VD) {
    raw_null_ostream NullOutStream = null;
    CXXNameMangler TrackVariableType = null;
    try {
      // When derived abi tags are disabled there is no need to make any list.
      if (DisableDerivedAbiTags) {
        return new SmallVector<StringRef>(4, new StringRef());
      }
      
      NullOutStream/*J*/= new raw_null_ostream();
      TrackVariableType/*J*/= new CXXNameMangler(/*Deref*/this, NullOutStream);
      TrackVariableType.disableDerivedAbiTags();
      
      TrackVariableType.mangleType(VD.getType());
      
      return new SmallVector<StringRef>(TrackVariableType.AbiTagsRoot.getSortedUniqueUsedAbiTags());
    } finally {
      if (TrackVariableType != null) { TrackVariableType.$destroy(); }
      if (NullOutStream != null) { NullOutStream.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CXXNameMangler::~CXXNameMangler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 214,
   FQN="(anonymous namespace)::CXXNameMangler::~CXXNameMangler", NM="_ZN12_GLOBAL__N_114CXXNameManglerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_114CXXNameManglerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Substitutions.$destroy();
    AbiTagsRoot.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + Context // NOI18N
              + ", Out=" + Out // NOI18N
              + ", NullOut=" + NullOut // NOI18N
              + ", DisableDerivedAbiTags=" + DisableDerivedAbiTags // NOI18N
              + ", Structor=" + Structor // NOI18N
              + ", StructorType=" + StructorType // NOI18N
              + ", SeqID=" + SeqID // NOI18N
              + ", FunctionTypeDepth=" + FunctionTypeDepth // NOI18N
              + ", AbiTags=" + AbiTags // NOI18N
              + ", AbiTagsRoot=" + AbiTagsRoot // NOI18N
              + ", Substitutions=" + Substitutions; // NOI18N
  }
}
