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

package org.clang.codegen.impl;

import org.clank.java.*;
import static org.clank.java.io.printf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.clang.basic.llvm.DenseMapInfoSelector;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 736,
 FQN="(anonymous namespace)::CGObjCCommonMac", NM="_ZN12_GLOBAL__N_115CGObjCCommonMacE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMacE")
//</editor-fold>
public abstract class CGObjCCommonMac extends /*public*/ CGObjCRuntime implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::SKIP_SCAN">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 738,
   FQN="(anonymous namespace)::CGObjCCommonMac::SKIP_SCAN", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac9SKIP_SCANE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac9SKIP_SCANE")
  //</editor-fold>
  public static class SKIP_SCAN {
  /*public:*/
    public /*uint*/int skip;
    public /*uint*/int scan;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::SKIP_SCAN::SKIP_SCAN">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 742,
     FQN="(anonymous namespace)::CGObjCCommonMac::SKIP_SCAN::SKIP_SCAN", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac9SKIP_SCANC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac9SKIP_SCANC1Ejj")
    //</editor-fold>
    public SKIP_SCAN() {
      this(0, 0);
    }
    public SKIP_SCAN(/*uint*/int _skip/*= 0*/) {
      this(_skip, 0);
    }
    public SKIP_SCAN(/*uint*/int _skip/*= 0*/, /*uint*/int _scan/*= 0*/) {
      // : skip(_skip), scan(_scan) 
      //START JInit
      this.skip = _skip;
      this.scan = _scan;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "skip=" + skip // NOI18N
                + ", scan=" + scan; // NOI18N
    }
  };
  
  /// opcode for captured block variables layout 'instructions'.
  /// In the following descriptions, 'I' is the value of the immediate field.
  /// (field following the opcode).
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BLOCK_LAYOUT_OPCODE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 750,
   FQN="(anonymous namespace)::CGObjCCommonMac::BLOCK_LAYOUT_OPCODE", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac19BLOCK_LAYOUT_OPCODEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac19BLOCK_LAYOUT_OPCODEE")
  //</editor-fold>
  public enum BLOCK_LAYOUT_OPCODE implements Native.NativeUIntEnum {
    /// An operator which affects how the following layout should be
    /// interpreted.
    ///   I == 0: Halt interpretation and treat everything else as
    ///           a non-pointer.  Note that this instruction is equal
    ///           to '\0'.
    ///   I != 0: Currently unused.
    BLOCK_LAYOUT_OPERATOR(0),
    
    /// The next I+1 bytes do not contain a value of object pointer type.
    /// Note that this can leave the stream unaligned, meaning that
    /// subsequent word-size instructions do not begin at a multiple of
    /// the pointer size.
    BLOCK_LAYOUT_NON_OBJECT_BYTES(1),
    
    /// The next I+1 words do not contain a value of object pointer type.
    /// This is simply an optimized version of BLOCK_LAYOUT_BYTES for
    /// when the required skip quantity is a multiple of the pointer size.
    BLOCK_LAYOUT_NON_OBJECT_WORDS(2),
    
    /// The next I+1 words are __strong pointers to Objective-C
    /// objects or blocks.
    BLOCK_LAYOUT_STRONG(3),
    
    /// The next I+1 words are pointers to __block variables.
    BLOCK_LAYOUT_BYREF(4),
    
    /// The next I+1 words are __weak pointers to Objective-C
    /// objects or blocks.
    BLOCK_LAYOUT_WEAK(5),
    
    /// The next I+1 words are __unsafe_unretained pointers to
    /// Objective-C objects or blocks.
    BLOCK_LAYOUT_UNRETAINED(6);
    /// All other opcodes are reserved.  Halt interpretation and
    /// treat everything else as opaque.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BLOCK_LAYOUT_OPCODE valueOf(int val) {
      BLOCK_LAYOUT_OPCODE out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BLOCK_LAYOUT_OPCODE[] VALUES;
      private static final BLOCK_LAYOUT_OPCODE[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BLOCK_LAYOUT_OPCODE kind : BLOCK_LAYOUT_OPCODE.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BLOCK_LAYOUT_OPCODE[min < 0 ? (1-min) : 0];
        VALUES = new BLOCK_LAYOUT_OPCODE[max >= 0 ? (1+max) : 0];
        for (BLOCK_LAYOUT_OPCODE kind : BLOCK_LAYOUT_OPCODE.values()) {
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
    private BLOCK_LAYOUT_OPCODE(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::RUN_SKIP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 798,
   FQN="(anonymous namespace)::CGObjCCommonMac::RUN_SKIP", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac8RUN_SKIPE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac8RUN_SKIPE")
  //</editor-fold>
  public static class RUN_SKIP implements NativeCloneable<RUN_SKIP>, ComparableLower {
  /*public:*/
    public  BLOCK_LAYOUT_OPCODE opcode;
    public CharUnits block_var_bytepos;
    public CharUnits block_var_size;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::RUN_SKIP::RUN_SKIP">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 803,
     FQN="(anonymous namespace)::CGObjCCommonMac::RUN_SKIP::RUN_SKIP", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac8RUN_SKIPC1ENS0_19BLOCK_LAYOUT_OPCODEEN5clang9CharUnitsES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac8RUN_SKIPC1ENS0_19BLOCK_LAYOUT_OPCODEEN5clang9CharUnitsES4_")
    //</editor-fold>
    public RUN_SKIP() {
      this(BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_OPERATOR, 
        CharUnits.Zero(), 
        CharUnits.Zero());
    }
    public RUN_SKIP( BLOCK_LAYOUT_OPCODE Opcode/*= BLOCK_LAYOUT_OPERATOR*/) {
      this(Opcode, 
        CharUnits.Zero(), 
        CharUnits.Zero());
    }
    public RUN_SKIP( BLOCK_LAYOUT_OPCODE Opcode/*= BLOCK_LAYOUT_OPERATOR*/, 
        CharUnits BytePos/*= CharUnits::Zero()*/) {
      this(Opcode, 
        BytePos, 
        CharUnits.Zero());
    }
    public RUN_SKIP( BLOCK_LAYOUT_OPCODE Opcode/*= BLOCK_LAYOUT_OPERATOR*/, 
        CharUnits BytePos/*= CharUnits::Zero()*/, 
        CharUnits Size/*= CharUnits::Zero()*/) {
      // : opcode(Opcode), block_var_bytepos(BytePos), block_var_size(Size) 
      //START JInit
      this.opcode = Opcode;
      this.block_var_bytepos = new CharUnits(BytePos);
      this.block_var_size = new CharUnits(Size);
      //END JInit
    }

    
    // Allow sorting based on byte pos.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::RUN_SKIP::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 809,
     FQN="(anonymous namespace)::CGObjCCommonMac::RUN_SKIP::operator<", NM="_ZNK12_GLOBAL__N_115CGObjCCommonMac8RUN_SKIPltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_115CGObjCCommonMac8RUN_SKIPltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ RUN_SKIP /*&*/ b) /*const*/ {
      return block_var_bytepos.$less(b.block_var_bytepos);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public RUN_SKIP clone() {
      return new RUN_SKIP(opcode, block_var_bytepos, block_var_size);
    }

    @Override
    public boolean $less(Object obj) {
      return $less((RUN_SKIP)obj);
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "opcode=" + opcode // NOI18N
                + ", block_var_bytepos=" + block_var_bytepos // NOI18N
                + ", block_var_size=" + block_var_size; // NOI18N
    }
  };
/*protected:*/
  protected final LLVMContext /*&*/ VMContext;
  // FIXME! May not be needing this after all.
  protected /*uint*/int ObjCABI;
  
  // arc/mrr layout of captured block literal variables.
  protected SmallVector<RUN_SKIP> RunSkipBlockVars;
  
  /// LazySymbols - Symbols to generate a lazy reference for. See
  /// DefinedSymbols and FinishModule().
  protected SetVector<IdentifierInfo /*P*/ > LazySymbols;
  
  /// DefinedSymbols - External symbols which are defined by this
  /// module. The symbols in this list and LazySymbols are used to add
  /// special linker symbols which ensure that Objective-C modules are
  /// linked properly.
  protected SetVector<IdentifierInfo /*P*/ > DefinedSymbols;
  
  /// ClassNames - uniqued class names.
  protected StringMap<GlobalVariable /*P*/ > ClassNames;
  
  /// MethodVarNames - uniqued method variable names.
  protected DenseMap<Selector, GlobalVariable /*P*/ > MethodVarNames;
  
  /// DefinedCategoryNames - list of category names in form Class_Category.
  protected SmallSetVector<std.string> DefinedCategoryNames;
  
  /// MethodVarTypes - uniqued method type signatures. We have to use
  /// a StringMap here because have no other unique reference.
  protected StringMap<GlobalVariable /*P*/ > MethodVarTypes;
  
  /// MethodDefinitions - map of methods which have been defined in
  /// this translation unit.
  protected DenseMap</*const*/ ObjCMethodDecl /*P*/ , Function /*P*/ > MethodDefinitions;
  
  /// PropertyNames - uniqued method variable names.
  protected DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ > PropertyNames;
  
  /// ClassReferences - uniqued class references.
  protected DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ > ClassReferences;
  
  /// SelectorReferences - uniqued selector references.
  protected DenseMap<Selector, GlobalVariable /*P*/ > SelectorReferences;
  
  /// Protocols - Protocols for which an objc_protocol structure has
  /// been emitted. Forward declarations are handled by creating an
  /// empty structure whose initializer is filled in when/if defined.
  protected DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ > Protocols;
  
  /// DefinedProtocols - Protocols which have actually been
  /// defined. We should not need this, see FIXME in GenerateProtocol.
  protected DenseSet<IdentifierInfo /*P*/ > DefinedProtocols;
  
  /// DefinedClasses - List of defined classes.
  protected SmallVector<GlobalValue /*P*/ > DefinedClasses;
  
  /// ImplementedClasses - List of @implemented classes.
  protected SmallVector</*const*/ ObjCInterfaceDecl /*P*/ > ImplementedClasses;
  
  /// DefinedNonLazyClasses - List of defined "non-lazy" classes.
  protected SmallVector<GlobalValue /*P*/ > DefinedNonLazyClasses;
  
  /// DefinedCategories - List of defined categories.
  protected SmallVector<GlobalValue /*P*/ > DefinedCategories;
  
  /// DefinedNonLazyCategories - List of defined "non-lazy" categories.
  protected SmallVector<GlobalValue /*P*/ > DefinedNonLazyCategories;
  
  /// GetNameForMethod - Return a name for the given method.
  /// \param[out] NameOut - The return value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetNameForMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5142,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetNameForMethod", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16GetNameForMethodEPKN5clang14ObjCMethodDeclEPKNS1_17ObjCContainerDeclERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16GetNameForMethodEPKN5clang14ObjCMethodDeclEPKNS1_17ObjCContainerDeclERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  protected void GetNameForMethod(/*const*/ ObjCMethodDecl /*P*/ D, 
                  /*const*/ ObjCContainerDecl /*P*/ CD, 
                  final SmallString/*&*/ Name) {
    raw_svector_ostream OS = null;
    try {
      OS/*J*/= new raw_svector_ostream(Name);
      assert ((CD != null)) : "Missing container decl in GetNameForMethod";
      OS.$out_char($$SOH).$out_char((D.isInstanceMethod() ? $$MINUS : $$PLUS)).$out_char(
          $$LSQUARE
      ).$out(CD.getName());
      {
        /*const*/ ObjCCategoryImplDecl /*P*/ CID = dyn_cast_ObjCCategoryImplDecl(D.getDeclContext$Const());
        if ((CID != null)) {
          $out_raw_ostream_ObjCCategoryImplDecl$C(OS.$out_char($$LPAREN), $Deref(CID)).$out_char($$RPAREN);
        }
      }
      OS.$out_char($$SPACE).$out(D.getSelector().getAsString()).$out_char($$RSQUARE);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  /// GetMethodVarName - Return a unique constant for the given
  /// selector's name. The return value has type char *.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetMethodVarName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5063,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetMethodVarName", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarNameEN5clang8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarNameEN5clang8SelectorE")
  //</editor-fold>
  protected Constant /*P*/ GetMethodVarName(Selector Sel) {
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = MethodVarNames.ref$at(Sel);
    
    // FIXME: Avoid std::string in "Sel.getAsString()"
    if (!(Entry.$deref() != null)) {
      Entry.$set(CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_METH_VAR_NAME_"), 
          ConstantDataArray.getString(VMContext, new StringRef(Sel.getAsString())), 
          new StringRef(((ObjCABI == 2) ? $("__TEXT,__objc_methname,cstring_literals") : $("__TEXT,__cstring,cstring_literals"))), 
          CharUnits.One(), true));
    }
    
    return CGObjCMacStatics.getConstantGEP(VMContext, Entry.$deref(), 0, 0);
  }

  
  // FIXME: Merge into a single cstring creation function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetMethodVarName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5079,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetMethodVarName", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarNameEPN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarNameEPN5clang14IdentifierInfoE")
  //</editor-fold>
  protected Constant /*P*/ GetMethodVarName(IdentifierInfo /*P*/ ID) {
    return GetMethodVarName(CGM.getContext().Selectors.getNullarySelector(ID));
  }

  
  /// GetMethodVarType - Return a unique constant for the given
  /// method's type encoding string. The return value has type char *.
  
  // FIXME: This is a horrible name.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetMethodVarType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5100,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetMethodVarType", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarTypeEPKN5clang14ObjCMethodDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarTypeEPKN5clang14ObjCMethodDeclEb")
  //</editor-fold>
  protected Constant /*P*/ GetMethodVarType(/*const*/ ObjCMethodDecl /*P*/ D) {
    return GetMethodVarType(D, 
                  false);
  }
  protected Constant /*P*/ GetMethodVarType(/*const*/ ObjCMethodDecl /*P*/ D, 
                  boolean Extended/*= false*/) {
    std.string TypeStr/*J*/= new std.string();
    if (CGM.getContext().getObjCEncodingForMethodDecl(D, TypeStr, Extended)) {
      return null;
    }
    
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = MethodVarTypes.ref$at(new StringRef(TypeStr));
    if (!(Entry.$deref() != null)) {
      Entry.$set(CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_METH_VAR_TYPE_"), 
          ConstantDataArray.getString(VMContext, new StringRef(TypeStr)), 
          new StringRef(((ObjCABI == 2) ? $("__TEXT,__objc_methtype,cstring_literals") : $("__TEXT,__cstring,cstring_literals"))), 
          CharUnits.One(), true));
    }
    
    return CGObjCMacStatics.getConstantGEP(VMContext, Entry.$deref(), 0, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetMethodVarType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5083,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetMethodVarType", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarTypeEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16GetMethodVarTypeEPKN5clang9FieldDeclE")
  //</editor-fold>
  protected Constant /*P*/ GetMethodVarType(/*const*/ FieldDecl /*P*/ Field) {
    std.string TypeStr/*J*/= new std.string();
    CGM.getContext().getObjCEncodingForType(Field.getType(), TypeStr, Field);
    
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = MethodVarTypes.ref$at(new StringRef(TypeStr));
    if (!(Entry.$deref() != null)) {
      Entry.$set(CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_METH_VAR_TYPE_"), 
          ConstantDataArray.getString(VMContext, new StringRef(TypeStr)), 
          new StringRef(((ObjCABI == 2) ? $("__TEXT,__objc_methtype,cstring_literals") : $("__TEXT,__cstring,cstring_literals"))), 
          CharUnits.One(), true));
    }
    
    return CGObjCMacStatics.getConstantGEP(VMContext, Entry.$deref(), 0, 0);
  }

  
  /// GetPropertyName - Return a unique constant for the given
  /// name. The return value has type char *.
  
  // FIXME: Merge into a single cstring creation function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetPropertyName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5120,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetPropertyName", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac15GetPropertyNameEPN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac15GetPropertyNameEPN5clang14IdentifierInfoE")
  //</editor-fold>
  protected Constant /*P*/ GetPropertyName(IdentifierInfo /*P*/ Ident) {
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = PropertyNames.ref$at(Ident);
    if (!(Entry.$deref() != null)) {
      Entry.$set(CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_PROP_NAME_ATTR_"), 
          ConstantDataArray.getString(VMContext, Ident.getName()), 
          new StringRef(/*KEEP_STR*/"__TEXT,__cstring,cstring_literals"), CharUnits.One(), true));
    }
    
    return CGObjCMacStatics.getConstantGEP(VMContext, Entry.$deref(), 0, 0);
  }

  
  // FIXME: This can be dropped once string functions are unified.
  
  // FIXME: Merge into a single cstring creation function.
  // FIXME: This Decl should be more precise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetPropertyTypeString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5134,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetPropertyTypeString", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac21GetPropertyTypeStringEPKN5clang16ObjCPropertyDeclEPKNS1_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac21GetPropertyTypeStringEPKN5clang16ObjCPropertyDeclEPKNS1_4DeclE")
  //</editor-fold>
  protected Constant /*P*/ GetPropertyTypeString(/*const*/ ObjCPropertyDecl /*P*/ PD, 
                       /*const*/ Decl /*P*/ Container) {
    std.string TypeStr/*J*/= new std.string();
    CGM.getContext().getObjCEncodingForPropertyDecl(PD, Container, TypeStr);
    return GetPropertyName($AddrOf(CGM.getContext().Idents.get(new StringRef(TypeStr))));
  }

  
  /// GetClassName - Return a unique constant for the given selector's
  /// runtime name (which may change via use of objc_runtime_name attribute on
  /// class or protocol definition. The return value has type char *.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4707,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetClassName", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac12GetClassNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac12GetClassNameEN4llvm9StringRefE")
  //</editor-fold>
  protected Constant /*P*/ GetClassName(StringRef RuntimeName) {
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = ClassNames.ref$at(/*NO_COPY*/RuntimeName);
    if (!(Entry.$deref() != null)) {
      Entry.$set(CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_CLASS_NAME_"), 
          ConstantDataArray.getString(VMContext, new StringRef(RuntimeName)), 
          new StringRef(((ObjCABI == 2) ? $("__TEXT,__objc_classname,cstring_literals") : $("__TEXT,__cstring,cstring_literals"))), 
          CharUnits.One(), true));
    }
    return CGObjCMacStatics.getConstantGEP(VMContext, Entry.$deref(), 0, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetMethodDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4719,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetMethodDefinition", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac19GetMethodDefinitionEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac19GetMethodDefinitionEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  protected Function /*P*/ GetMethodDefinition(/*const*/ ObjCMethodDecl /*P*/ MD) {
    DenseMapIterator</*const*/ ObjCMethodDecl /*P*/ , Function /*P*/ > I = MethodDefinitions.find(MD);
    if (I.$noteq(/*NO_ITER_COPY*/MethodDefinitions.end())) {
      return I.$arrow().second;
    }
    
    return null;
  }

  
  /// BuildIvarLayout - Builds ivar layout bitmap for the class
  /// implementation for the __strong or __weak case.
  ///
  /// \param hasMRCWeakIvars - Whether we are compiling in MRC and there
  ///   are any weak ivars defined directly in the class.  Meaningless unless
  ///   building a weak layout.  Does not guarantee that the layout will
  ///   actually have any entries, because the ivar might be under-aligned.
  
  /// BuildIvarLayout - Builds ivar layout bitmap for the class
  /// implementation for the __strong or __weak case.
  /// The layout map displays which words in ivar list must be skipped
  /// and which must be scanned by GC (see below). String is built of bytes.
  /// Each byte is divided up in two nibbles (4-bit each). Left nibble is count
  /// of words to skip and right nibble is count of words to scan. So, each
  /// nibble represents up to 15 workds to skip or scan. Skipping the rest is
  /// represented by a 0x00 byte which also ends the string.
  /// 1. when ForStrongLayout is true, following ivars are scanned:
  /// - id, Class
  /// - object *
  /// - __strong anything
  ///
  /// 2. When ForStrongLayout is false, following ivars are scanned:
  /// - __weak anything
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildIvarLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4990,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildIvarLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac15BuildIvarLayoutEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsES5_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac15BuildIvarLayoutEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsES5_bb")
  //</editor-fold>
  protected Constant /*P*/ BuildIvarLayout(/*const*/ ObjCImplementationDecl /*P*/ OMD, 
                 CharUnits beginOffset, CharUnits endOffset, 
                 boolean ForStrongLayout, boolean HasMRCWeakIvars) {
    IvarLayoutBuilder builder = null;
    try {
      // If this is MRC, and we're either building a strong layout or there
      // are no weak ivars, bail out early.
      org.llvm.ir.Type /*P*/ PtrTy = CGM.Unnamed_field9.Int8PtrTy;
      if (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC
         && !CGM.getLangOpts().ObjCAutoRefCount
         && (ForStrongLayout || !HasMRCWeakIvars)) {
        return Constant.getNullValue(PtrTy);
      }
      
      /*const*/ ObjCInterfaceDecl /*P*/ OI = OMD.getClassInterface$Const();
      SmallVector</*const*/ ObjCIvarDecl /*P*/ > ivars/*J*/= new SmallVector</*const*/ ObjCIvarDecl /*P*/ >(32, (/*const*/ ObjCIvarDecl /*P*/ )null);
      
      // GC layout strings include the complete object layout, possibly
      // inaccurately in the non-fragile ABI; the runtime knows how to fix this
      // up.
      //
      // ARC layout strings only include the class's ivars.  In non-fragile
      // runtimes, that means starting at InstanceStart, rounded up to word
      // alignment.  In fragile runtimes, there's no InstanceStart, so it means
      // starting at the offset of the first ivar, rounded up to word alignment.
      //
      // MRC weak layout strings follow the ARC style.
      CharUnits baseOffset/*J*/= new CharUnits();
      if (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
        for (/*const*/ ObjCIvarDecl /*P*/ IVD = OI.all_declared_ivar_begin$Const();
             (IVD != null); IVD = IVD.getNextIvar$Const())  {
          ivars.push_back(IVD);
        }
        if (isNonFragileABI()) {
          baseOffset.$assign(beginOffset); // InstanceStart
        } else if (!ivars.empty()) {
          baseOffset.$assignMove(
              CharUnits.fromQuantity(ComputeIvarBaseOffset(CGM, OMD, ivars.$at(0)))
          );
        } else {
          baseOffset.$assignMove(CharUnits.Zero());
        }
        
        baseOffset.$assignMove(baseOffset.alignTo(CGM.getPointerAlign()));
      } else {
        CGM.getContext().DeepCollectObjCIvars(OI, true, ivars);
        
        baseOffset.$assignMove(CharUnits.Zero());
      }
      if (ivars.empty()) {
        return Constant.getNullValue(PtrTy);
      }
      
      builder/*J*/= new IvarLayoutBuilder(CGM, new CharUnits(baseOffset), new CharUnits(endOffset), ForStrongLayout);
      ObjCIvarDecl2CharUnits fun = /*[&, this, &OMD]*/ (/*const*/ ObjCIvarDecl /*P*/ ivar) -> {
                return CharUnits.fromQuantity(ComputeIvarBaseOffset(CGM, OMD, ivar));
              };
      builder.visitAggregate(ivars.begin(), ivars.end(), CharUnits.Zero(), fun);
      if (!builder.hasBitmapData()) {
        return Constant.getNullValue(PtrTy);
      }
      
      SmallVectorUChar buffer/*J*/= new SmallVectorUChar(4, (/*uchar*/byte)0);
      Constant /*P*/ C = builder.buildBitmap(/*Deref*/this, buffer);
      if (CGM.getLangOpts().ObjCGCBitmapPrint && !buffer.empty()) {
        printf(/*KEEP_STR*/"\n%s ivar layout for class '%s': ", 
            ForStrongLayout ? $("strong") : $("weak"), 
            OMD.getClassInterface$Const().getName().str().c_str());
        builder.dump(new ArrayRefUChar(buffer));
      }
      return C;
    } finally {
      if (builder != null) { builder.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildStrongIvarLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 929,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildStrongIvarLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac21BuildStrongIvarLayoutEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac21BuildStrongIvarLayoutEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsES5_")
  //</editor-fold>
  protected Constant /*P*/ BuildStrongIvarLayout(/*const*/ ObjCImplementationDecl /*P*/ OI, 
                       CharUnits beginOffset, 
                       CharUnits endOffset) {
    return BuildIvarLayout(OI, new CharUnits(beginOffset), new CharUnits(endOffset), true, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildWeakIvarLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 935,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildWeakIvarLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac19BuildWeakIvarLayoutEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac19BuildWeakIvarLayoutEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsES5_b")
  //</editor-fold>
  protected Constant /*P*/ BuildWeakIvarLayout(/*const*/ ObjCImplementationDecl /*P*/ OI, 
                     CharUnits beginOffset, 
                     CharUnits endOffset, 
                     boolean hasMRCWeakIvars) {
    return BuildIvarLayout(OI, new CharUnits(beginOffset), new CharUnits(endOffset), false, hasMRCWeakIvars);
  }

  
  
  /// getBlockCaptureLifetime - This routine returns life time of the captured
  /// block variable for the purpose of block layout meta-data generation. FQT is
  /// the type of the variable captured in the block.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::getBlockCaptureLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2155,
   FQN="(anonymous namespace)::CGObjCCommonMac::getBlockCaptureLifetime", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac23getBlockCaptureLifetimeEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac23getBlockCaptureLifetimeEN5clang8QualTypeEb")
  //</editor-fold>
  protected Qualifiers.ObjCLifetime getBlockCaptureLifetime(QualType FQT, 
                         boolean ByrefLayout) {
    {
      // If it has an ownership qualifier, we're done.
      Qualifiers.ObjCLifetime lifetime = FQT.getObjCLifetime();
      if ((lifetime.getValue() != 0)) {
        return lifetime;
      }
    }
    
    // If it doesn't, and this is ARC, it has no ownership.
    if (CGM.getLangOpts().ObjCAutoRefCount) {
      return Qualifiers.ObjCLifetime.OCL_None;
    }
    
    // In MRC, retainable pointers are owned by non-__block variables.
    if (FQT.$arrow().isObjCObjectPointerType() || FQT.$arrow().isBlockPointerType()) {
      return ByrefLayout ? Qualifiers.ObjCLifetime.OCL_ExplicitNone : Qualifiers.ObjCLifetime.OCL_Strong;
    }
    
    return Qualifiers.ObjCLifetime.OCL_None;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::UpdateRunSkipBlockVars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2172,
   FQN="(anonymous namespace)::CGObjCCommonMac::UpdateRunSkipBlockVars", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac22UpdateRunSkipBlockVarsEbN5clang10Qualifiers12ObjCLifetimeENS1_9CharUnitsES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac22UpdateRunSkipBlockVarsEbN5clang10Qualifiers12ObjCLifetimeENS1_9CharUnitsES4_")
  //</editor-fold>
  protected void UpdateRunSkipBlockVars(boolean IsByref, 
                        Qualifiers.ObjCLifetime LifeTime, 
                        CharUnits FieldOffset, 
                        CharUnits FieldSize) {
    // __block variables are passed by their descriptor address.
    if (IsByref) {
      RunSkipBlockVars.push_back(new RUN_SKIP(BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_BYREF, new CharUnits(FieldOffset), 
              new CharUnits(FieldSize)));
    } else if (LifeTime == Qualifiers.ObjCLifetime.OCL_Strong) {
      RunSkipBlockVars.push_back(new RUN_SKIP(BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_STRONG, new CharUnits(FieldOffset), 
              new CharUnits(FieldSize)));
    } else if (LifeTime == Qualifiers.ObjCLifetime.OCL_Weak) {
      RunSkipBlockVars.push_back(new RUN_SKIP(BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_WEAK, new CharUnits(FieldOffset), 
              new CharUnits(FieldSize)));
    } else if (LifeTime == Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
      RunSkipBlockVars.push_back(new RUN_SKIP(BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_UNRETAINED, new CharUnits(FieldOffset), 
              new CharUnits(FieldSize)));
    } else {
      RunSkipBlockVars.push_back(new RUN_SKIP(BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_NON_OBJECT_BYTES, 
              new CharUnits(FieldOffset), 
              new CharUnits(FieldSize)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildRCBlockVarRecordLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2319,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildRCBlockVarRecordLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac27BuildRCBlockVarRecordLayoutEPKN5clang10RecordTypeENS1_9CharUnitsERbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac27BuildRCBlockVarRecordLayoutEPKN5clang10RecordTypeENS1_9CharUnitsERbb")
  //</editor-fold>
  protected void BuildRCBlockVarRecordLayout(/*const*/ RecordType /*P*/ RT, 
                             CharUnits BytePos, 
                             final bool$ref/*bool &*/ HasUnion) {
    BuildRCBlockVarRecordLayout(RT, 
                             BytePos, 
                             HasUnion, 
                             false);
  }
  protected void BuildRCBlockVarRecordLayout(/*const*/ RecordType /*P*/ RT, 
                             CharUnits BytePos, 
                             final bool$ref/*bool &*/ HasUnion, 
                             boolean ByrefLayout/*= false*/) {
    /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
    SmallVector</*const*/ FieldDecl /*P*/ > Fields/*J*/= new SmallVector</*const*/ FieldDecl /*P*/ >(16, RD.fields().begin(), RD.fields().end(), /*const*/ (FieldDecl /*P*/ )null);
    org.llvm.ir.Type /*P*/ Ty = CGM.getTypes().ConvertType(new QualType(RT, 0));
    /*const*/ StructLayout /*P*/ RecLayout = CGM.getDataLayout().getStructLayout(cast_StructType(Ty));
    
    BuildRCRecordLayout(RecLayout, RD, new ArrayRef</*const*/ FieldDecl /*P*/ >(Fields, true), new CharUnits(BytePos), HasUnion, ByrefLayout);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildRCRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2195,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildRCRecordLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac19BuildRCRecordLayoutEPKN4llvm12StructLayoutEPKN5clang10RecordDeclENS1_8ArrayRefIPKNS5_9FieldDeclEEENS5_9CharUnitsERbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac19BuildRCRecordLayoutEPKN4llvm12StructLayoutEPKN5clang10RecordDeclENS1_8ArrayRefIPKNS5_9FieldDeclEEENS5_9CharUnitsERbb")
  //</editor-fold>
  protected void BuildRCRecordLayout(/*const*/ StructLayout /*P*/ RecLayout, 
                     /*const*/ RecordDecl /*P*/ RD, 
                     ArrayRef</*const*/ FieldDecl /*P*/ > RecFields, 
                     CharUnits BytePos, final bool$ref/*bool &*/ HasUnion, 
                     boolean ByrefLayout) {
    boolean IsUnion = ((RD != null) && RD.isUnion());
    CharUnits MaxUnionSize = CharUnits.Zero();
    /*const*/ FieldDecl /*P*/ MaxField = null;
    /*const*/ FieldDecl /*P*/ LastFieldBitfieldOrUnnamed = null;
    CharUnits MaxFieldOffset = CharUnits.Zero();
    CharUnits LastBitfieldOrUnnamedOffset = CharUnits.Zero();
    if (RecFields.empty()) {
      return;
    }
    /*uint*/int ByteSizeInBits = CGM.getTarget().getCharWidth();
    
    for (/*uint*/int i = 0, e = RecFields.size(); i != e; ++i) {
      /*const*/ FieldDecl /*P*/ Field = RecFields.$at(i);
      // Note that 'i' here is actually the field index inside RD of Field,
      // although this dependency is hidden.
      final /*const*/ ASTRecordLayout /*&*/ RL = CGM.getContext().getASTRecordLayout(RD);
      CharUnits FieldOffset = CGM.getContext().toCharUnitsFromBits(RL.getFieldOffset(i));
      
      // Skip over unnamed or bitfields
      if (!(Field.getIdentifier() != null) || Field.isBitField()) {
        LastFieldBitfieldOrUnnamed = Field;
        LastBitfieldOrUnnamedOffset.$assign(FieldOffset);
        continue;
      }
      
      LastFieldBitfieldOrUnnamed = null;
      QualType FQT = Field.getType();
      if (FQT.$arrow().isRecordType() || FQT.$arrow().isUnionType()) {
        if (FQT.$arrow().isUnionType()) {
          HasUnion.$set(true);
        }
        
        BuildRCBlockVarRecordLayout(FQT.$arrow().getAs$RecordType(), 
            BytePos.$add(FieldOffset), HasUnion);
        continue;
      }
      {
        
        /*const*/ org.clang.ast.ArrayType /*P*/ Array = CGM.getContext().getAsArrayType(new QualType(FQT));
        if ((Array != null)) {
          /*const*/ ConstantArrayType /*P*/ CArray = dyn_cast_or_null_ConstantArrayType(Array);
          long/*uint64_t*/ ElCount = CArray.getSize().getZExtValue();
          assert ((CArray != null)) : "only array with known element size is supported";
          FQT.$assignMove(CArray.getElementType());
          {
            /*const*/ org.clang.ast.ArrayType /*P*/ Array$1;
            while (((/*P*/ Array$1 = CGM.getContext().getAsArrayType(new QualType(FQT))) != null)) {
              /*const*/ ConstantArrayType /*P*/ CArray$1 = dyn_cast_or_null_ConstantArrayType(Array$1);
              ElCount *= CArray$1.getSize().getZExtValue();
              FQT.$assignMove(CArray$1.getElementType());
            }
          }
          if (FQT.$arrow().isRecordType() && (ElCount != 0)) {
            int OldIndex = RunSkipBlockVars.size() - 1;
            /*const*/ RecordType /*P*/ RT = FQT.$arrow().getAs$RecordType();
            BuildRCBlockVarRecordLayout(RT, BytePos.$add(FieldOffset), 
                HasUnion);
            
            // Replicate layout information for each array element. Note that
            // one element is already done.
            long/*uint64_t*/ ElIx = $int2ulong(1);
            for (int FirstIndex = RunSkipBlockVars.size() - 1; $less_ulong(ElIx, ElCount); ElIx++) {
              CharUnits Size = CGM.getContext().getTypeSizeInChars(RT);
              for (int i$1 = OldIndex + 1; i$1 <= FirstIndex; ++i$1)  {
                RunSkipBlockVars.push_back(new RUN_SKIP(RunSkipBlockVars.$at(i$1).opcode, 
                        RunSkipBlockVars.$at(i$1).block_var_bytepos.$add(Size.$star(ElIx)), 
                        new CharUnits(RunSkipBlockVars.$at(i$1).block_var_size)));
              }
            }
            continue;
          }
        }
      }
      CharUnits FieldSize = CGM.getContext().getTypeSizeInChars(Field.getType());
      if (IsUnion) {
        CharUnits UnionIvarSize = new CharUnits(FieldSize);
        if (UnionIvarSize.$greater(MaxUnionSize)) {
          MaxUnionSize.$assign(UnionIvarSize);
          MaxField = Field;
          MaxFieldOffset.$assign(FieldOffset);
        }
      } else {
        UpdateRunSkipBlockVars(false, 
            getBlockCaptureLifetime(new QualType(FQT), ByrefLayout), 
            BytePos.$add(FieldOffset), 
            new CharUnits(FieldSize));
      }
    }
    if ((LastFieldBitfieldOrUnnamed != null)) {
      if (LastFieldBitfieldOrUnnamed.isBitField()) {
        // Last field was a bitfield. Must update the info.
        long/*uint64_t*/ BitFieldSize = $uint2ulong(LastFieldBitfieldOrUnnamed.getBitWidthValue(CGM.getContext()));
        /*uint*/int UnsSize = $ullong2uint(($div_ulong_uint(BitFieldSize, ByteSizeInBits))
           + ((($rem_ulong_uint(BitFieldSize, ByteSizeInBits)) != $int2ullong(0)) ? 1 : 0));
        CharUnits Size = CharUnits.fromQuantity($uint2long(UnsSize));
        Size.$addassign(LastBitfieldOrUnnamedOffset);
        UpdateRunSkipBlockVars(false, 
            getBlockCaptureLifetime(LastFieldBitfieldOrUnnamed.getType(), 
                ByrefLayout), 
            BytePos.$add(LastBitfieldOrUnnamedOffset), 
            new CharUnits(Size));
      } else {
        assert (!(LastFieldBitfieldOrUnnamed.getIdentifier() != null)) : "Expected unnamed";
        // Last field was unnamed. Must update skip info.
        CharUnits FieldSize = CGM.getContext().getTypeSizeInChars(LastFieldBitfieldOrUnnamed.getType());
        UpdateRunSkipBlockVars(false, 
            getBlockCaptureLifetime(LastFieldBitfieldOrUnnamed.getType(), 
                ByrefLayout), 
            BytePos.$add(LastBitfieldOrUnnamedOffset), 
            new CharUnits(FieldSize));
      }
    }
    if ((MaxField != null)) {
      UpdateRunSkipBlockVars(false, 
          getBlockCaptureLifetime(MaxField.getType(), ByrefLayout), 
          BytePos.$add(MaxFieldOffset), 
          new CharUnits(MaxUnionSize));
    }
  }

  
  
  /// InlineLayoutInstruction - This routine produce an inline instruction for the
  /// block variable layout if it can. If not, it returns 0. Rules are as follow:
  /// If ((uintptr_t) layout) < (1 << 12), the layout is inline. In the 64bit world,
  /// an inline layout of value 0x0000000000000xyz is interpreted as follows:
  /// x captured object pointers of BLOCK_LAYOUT_STRONG. Followed by
  /// y captured object of BLOCK_LAYOUT_BYREF. Followed by
  /// z captured object of BLOCK_LAYOUT_WEAK. If any of the above is missing, zero
  /// replaces it. For example, 0x00000x00 means x BLOCK_LAYOUT_STRONG and no
  /// BLOCK_LAYOUT_BYREF and no BLOCK_LAYOUT_WEAK objects are captured.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::InlineLayoutInstruction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2341,
   FQN="(anonymous namespace)::CGObjCCommonMac::InlineLayoutInstruction", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac23InlineLayoutInstructionERN4llvm15SmallVectorImplIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac23InlineLayoutInstructionERN4llvm15SmallVectorImplIhEE")
  //</editor-fold>
  protected long/*uint64_t*/ InlineLayoutInstruction(final SmallVectorImplUChar /*&*/ Layout) {
    long/*uint64_t*/ Result = $int2ulong(0);
    if ($lesseq_uint(Layout.size(), 3)) {
      /*uint*/int size = Layout.size();
      /*uint*/int strong_word_count = 0;
      /*uint*/int byref_word_count = 0;
      /*uint*/int weak_word_count = 0;
      /*uchar*/byte inst;
       BLOCK_LAYOUT_OPCODE opcode;
      switch (size) {
       case 3:
        inst = Layout.$at(0);
        opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
        if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_STRONG) {
          strong_word_count = ($uchar2int(inst) & 0xF) + 1;
        } else {
          return $int2ulong(0);
        }
        inst = Layout.$at(1);
        opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
        if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_BYREF) {
          byref_word_count = ($uchar2int(inst) & 0xF) + 1;
        } else {
          return $int2ulong(0);
        }
        inst = Layout.$at(2);
        opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
        if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_WEAK) {
          weak_word_count = ($uchar2int(inst) & 0xF) + 1;
        } else {
          return $int2ulong(0);
        }
        break;
       case 2:
        inst = Layout.$at(0);
        opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
        if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_STRONG) {
          strong_word_count = ($uchar2int(inst) & 0xF) + 1;
          inst = Layout.$at(1);
          opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
          if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_BYREF) {
            byref_word_count = ($uchar2int(inst) & 0xF) + 1;
          } else if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_WEAK) {
            weak_word_count = ($uchar2int(inst) & 0xF) + 1;
          } else {
            return $int2ulong(0);
          }
        } else if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_BYREF) {
          byref_word_count = ($uchar2int(inst) & 0xF) + 1;
          inst = Layout.$at(1);
          opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
          if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_WEAK) {
            weak_word_count = ($uchar2int(inst) & 0xF) + 1;
          } else {
            return $int2ulong(0);
          }
        } else {
          return $int2ulong(0);
        }
        break;
       case 1:
        inst = Layout.$at(0);
        opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
        if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_STRONG) {
          strong_word_count = ($uchar2int(inst) & 0xF) + 1;
        } else if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_BYREF) {
          byref_word_count = ($uchar2int(inst) & 0xF) + 1;
        } else if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_WEAK) {
          weak_word_count = ($uchar2int(inst) & 0xF) + 1;
        } else {
          return $int2ulong(0);
        }
        break;
       default:
        return $int2ulong(0);
      }
      
      // Cannot inline when any of the word counts is 15. Because this is one less
      // than the actual work count (so 15 means 16 actual word counts),
      // and we can only display 0 thru 15 word counts.
      if (strong_word_count == 16 || byref_word_count == 16 || weak_word_count == 16) {
        return $int2ulong(0);
      }
      
      /*uint*/int count = (strong_word_count != 0 ? 1 : 0) + (byref_word_count != 0 ? 1 : 0) + ((weak_word_count != 0) ? 1 : 0);
      if (size == count) {
        if ((strong_word_count != 0)) {
          Result = $uint2ulong(strong_word_count);
        }
        Result <<= 4;
        if ((byref_word_count != 0)) {
          Result += $uint2ullong(byref_word_count);
        }
        Result <<= 4;
        if ((weak_word_count != 0)) {
          Result += $uint2ullong(weak_word_count);
        }
      }
    }
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::getBitmapBlockLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2438,
   FQN="(anonymous namespace)::CGObjCCommonMac::getBitmapBlockLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac20getBitmapBlockLayoutEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac20getBitmapBlockLayoutEb")
  //</editor-fold>
  protected Constant /*P*/ getBitmapBlockLayout(boolean ComputeByrefLayout) {
    Constant /*P*/ nullPtr = Constant.getNullValue(CGM.Unnamed_field9.Int8PtrTy);
    if (RunSkipBlockVars.empty()) {
      return nullPtr;
    }
    /*uint*/int WordSizeInBits = $ulong2uint(CGM.getTarget().getPointerWidth(0));
    /*uint*/int ByteSizeInBits = CGM.getTarget().getCharWidth();
    /*uint*/int WordSizeInBytes = $div_uint(WordSizeInBits, ByteSizeInBits);
    
    // Sort on byte position; captures might not be allocated in order,
    // and unions can do funny things.
    llvm.array_pod_sort(RunSkipBlockVars.begin(), RunSkipBlockVars.end());
    SmallVectorUChar Layout/*J*/= new SmallVectorUChar(16, (/*uchar*/byte)0);
    
    /*uint*/int size = RunSkipBlockVars.size();
    for (/*uint*/int i = 0; $less_uint(i, size); i++) {
       BLOCK_LAYOUT_OPCODE opcode = RunSkipBlockVars.$at(i).opcode;
      CharUnits start_byte_pos = new CharUnits(RunSkipBlockVars.$at(i).block_var_bytepos);
      CharUnits end_byte_pos = new CharUnits(start_byte_pos);
      /*uint*/int j = i + 1;
      while ($less_uint(j, size)) {
        if (opcode == RunSkipBlockVars.$at(j).opcode) {
          end_byte_pos.$assign(RunSkipBlockVars.$at(j++).block_var_bytepos);
          i++;
        } else {
          break;
        }
      }
      CharUnits size_in_bytes = end_byte_pos.$sub(start_byte_pos).$add(RunSkipBlockVars.$at(j - 1).block_var_size);
      if ($less_uint(j, size)) {
        CharUnits gap = RunSkipBlockVars.$at(j).block_var_bytepos.$sub(
            RunSkipBlockVars.$at(j - 1).block_var_bytepos
        ).$sub(RunSkipBlockVars.$at(j - 1).block_var_size);
        size_in_bytes.$addassign(gap);
      }
      CharUnits residue_in_bytes = CharUnits.Zero();
      if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_NON_OBJECT_BYTES) {
        residue_in_bytes.$assignMove(size_in_bytes.$mod($uint2long(WordSizeInBytes)));
        size_in_bytes.$minusassign(residue_in_bytes);
        opcode = BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_NON_OBJECT_WORDS;
      }
      
      /*uint*/int size_in_words = $llong2uint(size_in_bytes.getQuantity() / $uint2llong(WordSizeInBytes));
      while ($greatereq_uint(size_in_words, 16)) {
        // Note that value in imm. is one less that the actual
        // value. So, 0xf means 16 words follow!
        /*uchar*/byte inst = $int2uchar((opcode.getValue() << 4) | 0xf);
        Layout.push_back(inst);
        size_in_words -= 16;
      }
      if ($greater_uint(size_in_words, 0)) {
        // Note that value in imm. is one less that the actual
        // value. So, we subtract 1 away!
        /*uchar*/byte inst = $uint2uchar((opcode.getValue() << 4) | (size_in_words - 1));
        Layout.push_back(inst);
      }
      if (residue_in_bytes.$greater(CharUnits.Zero())) {
        /*uchar*/byte inst = $long2uchar((BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_NON_OBJECT_BYTES.getValue() << 4) | (residue_in_bytes.getQuantity() - 1));
        Layout.push_back(inst);
      }
    }
    while (!Layout.empty()) {
      /*uchar*/byte inst = Layout.back();
       BLOCK_LAYOUT_OPCODE opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst) >> 4));
      if (opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_NON_OBJECT_BYTES || opcode == BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_NON_OBJECT_WORDS) {
        Layout.pop_back();
      } else {
        break;
      }
    }
    
    long/*uint64_t*/ Result = InlineLayoutInstruction(Layout);
    if (Result != $int2ullong(0)) {
      // Block variable layout instruction has been inlined.
      if (CGM.getLangOpts().ObjCGCBitmapPrint) {
        if (ComputeByrefLayout) {
          printf(/*KEEP_STR*/"\n Inline BYREF variable layout: ");
        } else {
          printf(/*KEEP_STR*/"\n Inline block variable layout: ");
        }
        printf(/*KEEP_STR*/"0x0%llx", Result);
        {
          /*ullong*/long numStrong = (Result & $int2ullong(0xF00)) >>> 8;
          if ((numStrong != 0)) {
            printf(/*KEEP_STR*/", BL_STRONG:%d", (int)$ullong2int(numStrong));
          }
        }
        {
          /*ullong*/long numByref = (Result & $int2ullong(0x0F0)) >>> 4;
          if ((numByref != 0)) {
            printf(/*KEEP_STR*/", BL_BYREF:%d", (int)$ullong2int(numByref));
          }
        }
        {
          /*ullong*/long numWeak = (Result & $int2ullong(0x00F)) >>> 0;
          if ((numWeak != 0)) {
            printf(/*KEEP_STR*/", BL_WEAK:%d", (int)$ullong2int(numWeak));
          }
        }
        printf(/*KEEP_STR*/", BL_OPERATOR:0\n");
      }
      return ConstantInt.get(CGM.Unnamed_field8.IntPtrTy, Result);
    }
    
    /*uchar*/byte inst = $int2uchar((BLOCK_LAYOUT_OPCODE.BLOCK_LAYOUT_OPERATOR.getValue() << 4) | 0);
    Layout.push_back(inst);
    std.string BitMap/*J*/= new std.string();
    for (/*uint*/int i = 0, e = Layout.size(); i != e; i++)  {
      BitMap.$addassign_T(Layout.$at(i));
    }
    if (CGM.getLangOpts().ObjCGCBitmapPrint) {
      if (ComputeByrefLayout) {
        printf(/*KEEP_STR*/"\n Byref variable layout: ");
      } else {
        printf(/*KEEP_STR*/"\n Block variable layout: ");
      }
      for (/*uint*/int i = 0, e = BitMap.size(); i != e; i++) {
        /*uchar*/byte inst$1 = BitMap.$at(i);
         BLOCK_LAYOUT_OPCODE opcode =  BLOCK_LAYOUT_OPCODE.valueOf(($uchar2int(inst$1) >> 4));
        /*uint*/int delta = 1;
        switch (opcode) {
         case BLOCK_LAYOUT_OPERATOR:
          printf(/*KEEP_STR*/"BL_OPERATOR:");
          delta = 0;
          break;
         case BLOCK_LAYOUT_NON_OBJECT_BYTES:
          printf(/*KEEP_STR*/"BL_NON_OBJECT_BYTES:");
          break;
         case BLOCK_LAYOUT_NON_OBJECT_WORDS:
          printf(/*KEEP_STR*/"BL_NON_OBJECT_WORD:");
          break;
         case BLOCK_LAYOUT_STRONG:
          printf(/*KEEP_STR*/"BL_STRONG:");
          break;
         case BLOCK_LAYOUT_BYREF:
          printf(/*KEEP_STR*/"BL_BYREF:");
          break;
         case BLOCK_LAYOUT_WEAK:
          printf(/*KEEP_STR*/"BL_WEAK:");
          break;
         case BLOCK_LAYOUT_UNRETAINED:
          printf(/*KEEP_STR*/"BL_UNRETAINED:");
          break;
        }
        // Actual value of word count is one more that what is in the imm.
        // field of the instruction
        printf(/*KEEP_STR*/"%d", ($uchar2int(inst$1) & 0xf) + delta);
        if ($less_uint(i, e - 1)) {
          printf(/*KEEP_STR*/", ");
        } else {
          printf(/*KEEP_STR*/"\n");
        }
      }
    }
    
    GlobalVariable /*P*/ Entry = CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_CLASS_NAME_"), 
        ConstantDataArray.getString(VMContext, new StringRef(BitMap), false), 
        new StringRef(/*KEEP_STR*/"__TEXT,__objc_classname,cstring_literals"), CharUnits.One(), true);
    return CGObjCMacStatics.getConstantGEP(VMContext, Entry, 0, 0);
  }

  
  /// GetIvarLayoutName - Returns a unique constant for the given
  /// ivar layout bitmap.
  
  /// GetIvarLayoutName - Returns a unique constant for the given
  /// ivar layout bitmap.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetIvarLayoutName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4730,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetIvarLayoutName", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac17GetIvarLayoutNameEPN5clang14IdentifierInfoERKNS_21ObjCCommonTypesHelperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac17GetIvarLayoutNameEPN5clang14IdentifierInfoERKNS_21ObjCCommonTypesHelperE")
  //</editor-fold>
  protected Constant /*P*/ GetIvarLayoutName(IdentifierInfo /*P*/ Ident, 
                   final /*const*/ ObjCCommonTypesHelper /*&*/ ObjCTypes) {
    return Constant.getNullValue(ObjCTypes.Int8PtrTy);
  }

  
  /// EmitPropertyList - Emit the given property list. The return
  /// value has type PropertyListPtrTy.
  
  /*
  struct _objc_property {
  const char * const name;
  const char * const attributes;
  };
  
  struct _objc_property_list {
  uint32_t entsize; // sizeof (struct _objc_property)
  uint32_t prop_count;
  struct _objc_property[prop_count];
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::EmitPropertyList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2941,
   FQN="(anonymous namespace)::CGObjCCommonMac::EmitPropertyList", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16EmitPropertyListEN4llvm5TwineEPKN5clang4DeclEPKNS3_17ObjCContainerDeclERKNS_21ObjCCommonTypesHelperEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16EmitPropertyListEN4llvm5TwineEPKN5clang4DeclEPKNS3_17ObjCContainerDeclERKNS_21ObjCCommonTypesHelperEb")
  //</editor-fold>
  protected Constant /*P*/ EmitPropertyList(Twine Name, 
                  /*const*/ Decl /*P*/ Container, 
                  /*const*/ ObjCContainerDecl /*P*/ OCD, 
                  final /*const*/ ObjCCommonTypesHelper /*&*/ ObjCTypes, 
                  boolean IsClassProperty) {
    if (IsClassProperty) {
      // Make this entry NULL for OS X with deployment target < 10.11, for iOS
      // with deployment target < 9.0.
      final /*const*/ Triple /*&*/ $Triple = CGM.getTarget().getTriple();
      if (($Triple.isMacOSX() && $Triple.isMacOSXVersionLT(10, 11))
         || ($Triple.isiOS() && $Triple.isOSVersionLT(9))) {
        return Constant.getNullValue(ObjCTypes.PropertyListPtrTy);
      }
    }
    
    SmallVector<Constant /*P*/ > Properties/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    SmallPtrSet</*const*/ IdentifierInfo /*P*/ > PropertySet/*J*/= new SmallPtrSet</*const*/ IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    
    ObjCPropertyDecl2Void AddProperty = /*[&, this, &Container, &Properties, &ObjCTypes]*/ (/*const*/ ObjCPropertyDecl /*P*/ PD) -> {
          Constant /*P*/ Prop[/*2*/] = new Constant /*P*/  [/*2*/] {
            GetPropertyName(PD.getIdentifier()), 
            GetPropertyTypeString(PD, Container)};
          Properties.push_back(ConstantStruct.get(ObjCTypes.PropertyTy, new ArrayRef<Constant /*P*/ >(Prop, true)));
        };
    {
      /*const*/ ObjCInterfaceDecl /*P*/ OID = dyn_cast_ObjCInterfaceDecl(OCD);
      if ((OID != null)) {
        for (/*const*/ ObjCCategoryDecl /*P*/ ClassExt : OID.known_extensions())  {
          for (ObjCPropertyDecl /*P*/ PD : ClassExt.properties()) {
            if (IsClassProperty != PD.isClassProperty()) {
              continue;
            }
            PropertySet.insert(PD.getIdentifier());
            AddProperty.$call(PD);
          }
        }
      }
    }
    
    for (/*const*/ ObjCPropertyDecl /*P*/ PD : OCD.properties()) {
      if (IsClassProperty != PD.isClassProperty()) {
        continue;
      }
      // Don't emit duplicate metadata for properties that were already in a
      // class extension.
      if (!PropertySet.insert(PD.getIdentifier()).second) {
        continue;
      }
      AddProperty.$call(PD);
    }
    {
      
      /*const*/ ObjCInterfaceDecl /*P*/ OID = dyn_cast_ObjCInterfaceDecl(OCD);
      if ((OID != null)) {
        for (/*const*/ ObjCProtocolDecl /*P*/ P : OID.all_referenced_protocols())  {
          PushProtocolProperties(PropertySet, Properties, Container, P, ObjCTypes, 
              IsClassProperty);
        }
      } else {
        /*const*/ ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(OCD);
        if ((CD != null)) {
          for (/*const*/ ObjCProtocolDecl /*P*/ P : CD.protocols())  {
            PushProtocolProperties(PropertySet, Properties, Container, P, ObjCTypes, 
                IsClassProperty);
          }
        }
      }
    }
    
    // Return null for empty list.
    if (Properties.empty()) {
      return Constant.getNullValue(ObjCTypes.PropertyListPtrTy);
    }
    
    /*uint*/int PropertySize = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.PropertyTy));
    Constant /*P*/ Values[/*3*/] = new Constant /*P*/  [3];
    Values[0] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(PropertySize));
    Values[1] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Properties.size()));
    org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(ObjCTypes.PropertyTy, 
        $uint2ulong(Properties.size()));
    Values[2] = ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Properties, true));
    Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
    
    GlobalVariable /*P*/ GV = CreateMetadataVar(new Twine(Name), Init, 
        new StringRef((ObjCABI == 2) ? $("__DATA, __objc_const") : $("__OBJC,__property,regular,no_dead_strip")), 
        CGM.getPointerAlign(), 
        true);
    return ConstantExpr.getBitCast(GV, ObjCTypes.PropertyListPtrTy);
  }

  
  /// EmitProtocolMethodTypes - Generate the array of extended method type 
  /// strings. The return value has type Int8PtrPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::EmitProtocolMethodTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3016,
   FQN="(anonymous namespace)::CGObjCCommonMac::EmitProtocolMethodTypes", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac23EmitProtocolMethodTypesEN4llvm5TwineENS1_8ArrayRefIPNS1_8ConstantEEERKNS_21ObjCCommonTypesHelperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac23EmitProtocolMethodTypesEN4llvm5TwineENS1_8ArrayRefIPNS1_8ConstantEEERKNS_21ObjCCommonTypesHelperE")
  //</editor-fold>
  protected Constant /*P*/ EmitProtocolMethodTypes(Twine Name, 
                         ArrayRef<Constant /*P*/ > MethodTypes, 
                         final /*const*/ ObjCCommonTypesHelper /*&*/ ObjCTypes) {
    // Return null for empty list.
    if (MethodTypes.empty()) {
      return Constant.getNullValue(ObjCTypes.Int8PtrPtrTy);
    }
    
    org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(ObjCTypes.Int8PtrTy, 
        $uint2ulong(MethodTypes.size()));
    Constant /*P*/ Init = ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(MethodTypes));
    
    GlobalVariable /*P*/ GV = CreateMetadataVar(new Twine(Name), Init, (ObjCABI == 2) ? new StringRef(/*KEEP_STR*/"__DATA, __objc_const") : new StringRef(), 
        CGM.getPointerAlign(), true);
    return ConstantExpr.getBitCast(GV, ObjCTypes.Int8PtrPtrTy);
  }

  
  /// PushProtocolProperties - Push protocol's property on the input stack.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::PushProtocolProperties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2905,
   FQN="(anonymous namespace)::CGObjCCommonMac::PushProtocolProperties", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac22PushProtocolPropertiesERN4llvm11SmallPtrSetIPKN5clang14IdentifierInfoELj16EEERNS1_15SmallVectorImplIPNS1_8ConstantEEEPKNS3_4DeclEPKNS3_16ObjCProtocolDeclERKNS_21ObjCCommonTypesHelperEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac22PushProtocolPropertiesERN4llvm11SmallPtrSetIPKN5clang14IdentifierInfoELj16EEERNS1_15SmallVectorImplIPNS1_8ConstantEEEPKNS3_4DeclEPKNS3_16ObjCProtocolDeclERKNS_21ObjCCommonTypesHelperEb")
  //</editor-fold>
  protected void PushProtocolProperties(final SmallPtrSet</*const*/ IdentifierInfo /*P*/ > /*&*/ PropertySet, 
                        final SmallVectorImpl<Constant /*P*/ > /*&*/ Properties, 
                        /*const*/ Decl /*P*/ Container, 
                        /*const*/ ObjCProtocolDecl /*P*/ Proto, 
                        final /*const*/ ObjCCommonTypesHelper /*&*/ ObjCTypes, 
                        boolean IsClassProperty) {
    for (/*const*/ ObjCProtocolDecl /*P*/ P : Proto.protocols())  {
      PushProtocolProperties(PropertySet, Properties, Container, P, ObjCTypes, 
          IsClassProperty);
    }
    
    for (/*const*/ ObjCPropertyDecl /*P*/ PD : Proto.properties()) {
      if (IsClassProperty != PD.isClassProperty()) {
        continue;
      }
      if (!PropertySet.insert(PD.getIdentifier()).second) {
        continue;
      }
      Constant /*P*/ Prop[/*2*/] = new Constant /*P*/  [/*2*/] {
        GetPropertyName(PD.getIdentifier()), 
        GetPropertyTypeString(PD, Container)
      };
      Properties.push_back(ConstantStruct.get(ObjCTypes.PropertyTy, new ArrayRef<Constant /*P*/ >(Prop, true)));
    }
  }

  
  /// GetProtocolRef - Return a reference to the internal protocol
  /// description, creating an empty one if it has not been
  /// defined. The return value has type ProtocolPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2679,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetProtocolRef", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac14GetProtocolRefEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac14GetProtocolRefEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  protected Constant /*P*/ GetProtocolRef(/*const*/ ObjCProtocolDecl /*P*/ PD) {
    if ((DefinedProtocols.count(PD.getIdentifier()) != 0)) {
      return GetOrEmitProtocol(PD);
    }
    
    return GetOrEmitProtocolRef(PD);
  }

  
  /// Return a reference to the given Class using runtime calls rather than
  /// by a symbol reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::EmitClassRefViaRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2686,
   FQN="(anonymous namespace)::CGObjCCommonMac::EmitClassRefViaRuntime", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac22EmitClassRefViaRuntimeERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclERNS_21ObjCCommonTypesHelperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac22EmitClassRefViaRuntimeERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclERNS_21ObjCCommonTypesHelperE")
  //</editor-fold>
  protected Value /*P*/ EmitClassRefViaRuntime(final CodeGenFunction /*&*/ CGF, 
                        /*const*/ ObjCInterfaceDecl /*P*/ ID, 
                        final ObjCCommonTypesHelper /*&*/ ObjCTypes) {
    Constant /*P*/ lookUpClassFn = ObjCTypes.getLookUpClassFn();
    
    Value /*P*/ className = CGF.CGM.GetAddrOfConstantCString(ID.getObjCRuntimeNameAsString().$string()).
        getPointer();
    final ASTContext /*&*/ ctx = CGF.CGM.getContext();
    className
       = CGF.Builder.CreateBitCast(className, 
        CGF.ConvertType(ctx.getPointerType(ctx.CharTy.withConst())));
    CallInst /*P*/ call = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(lookUpClassFn, new ArrayRef<Value /*P*/ >(className, true));
    call.setDoesNotThrow();
    return call;
  }

/*public:*/
  /// CreateMetadataVar - Create a global variable with internal
  /// linkage for use by the Objective-C runtime.
  ///
  /// This is a convenience wrapper which not only creates the
  /// variable, but also sets the section and alignment and adds the
  /// global to the "llvm.used" list.
  ///
  /// \param Name - The variable name.
  /// \param Init - The variable initializer; this is also used to
  /// define the type of the variable.
  /// \param Section - The section the variable should go into, or empty.
  /// \param Align - The alignment for the variable, or 0.
  /// \param AddToUsed - Whether the variable should be added to
  /// "llvm.used".
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::CreateMetadataVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3636,
   FQN="(anonymous namespace)::CGObjCCommonMac::CreateMetadataVar", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac17CreateMetadataVarEN4llvm5TwineEPNS1_8ConstantENS1_9StringRefEN5clang9CharUnitsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac17CreateMetadataVarEN4llvm5TwineEPNS1_8ConstantENS1_9StringRefEN5clang9CharUnitsEb")
  //</editor-fold>
  public GlobalVariable /*P*/ CreateMetadataVar(Twine Name, 
                   Constant /*P*/ Init, 
                   StringRef Section, 
                   CharUnits Align, 
                   boolean AddToUsed) {
    org.llvm.ir.Type /*P*/ Ty = Init.getType();
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), Ty, false, 
        GlobalValue.LinkageTypes.PrivateLinkage, Init, Name);
     });
    if (!Section.empty()) {
      GV.setSection(new StringRef(Section));
    }
    GV.setAlignment($long2uint(Align.getQuantity()));
    if (AddToUsed) {
      CGM.addCompilerUsedGlobal(GV);
    }
    return GV;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::EmitMessageSend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1865,
   FQN="(anonymous namespace)::CGObjCCommonMac::EmitMessageSend", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac15EmitMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeEPN4llvm5ValueES9_S6_bRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclEPKNS1_17ObjCInterfaceDeclERKNS_21ObjCCommonTypesHelperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac15EmitMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeEPN4llvm5ValueES9_S6_bRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclEPKNS1_17ObjCInterfaceDeclERKNS_21ObjCCommonTypesHelperE")
  //</editor-fold>
  protected RValue EmitMessageSend(final CodeGenFunction /*&*/ CGF, 
                 ReturnValueSlot Return, 
                 QualType ResultType, 
                 Value /*P*/ Sel, 
                 Value /*P*/ Arg0, 
                 QualType Arg0Ty, 
                 boolean IsSuper, 
                 final /*const*/ CallArgList /*&*/ CallArgs, 
                 /*const*/ ObjCMethodDecl /*P*/ Method, 
                 /*const*/ ObjCInterfaceDecl /*P*/ ClassReceiver, 
                 final /*const*/ ObjCCommonTypesHelper /*&*/ ObjCTypes) {
    CallArgList ActualArgs = null;
    try {
      ActualArgs/*J*/= new CallArgList();
      if (!IsSuper) {
        Arg0 = CGF.Builder.CreateBitCast(Arg0, ObjCTypes.ObjectPtrTy);
      }
      ActualArgs.add(RValue.get(Arg0), new QualType(Arg0Ty));
      ActualArgs.add(RValue.get(Sel), CGF.getContext().getObjCSelType());
      ActualArgs.addFrom(CallArgs);
      
      // If we're calling a method, use the formal signature.
      CGObjCRuntime.MessageSendInfo MSI = getMessageSendInfo(Method, new QualType(ResultType), ActualArgs);
      if ((Method != null)) {
        assert ($eq_CanQual$T_CanQual$U(CGM.getContext().getCanonicalType(Method.getReturnType()), CGM.getContext().getCanonicalType(/*NO_COPY*/ResultType))) : "Result type mismatch!";
      }
      
      boolean ReceiverCanBeNull = true;
      
      // Super dispatch assumes that self is non-null; even the messenger
      // doesn't have a null check internally.
      if (IsSuper) {
        ReceiverCanBeNull = false;
        // If this is a direct dispatch of a class method, check whether the class,
        // or anything in its hierarchy, was weak-linked.
      } else if ((ClassReceiver != null) && (Method != null) && Method.isClassMethod()) {
        ReceiverCanBeNull = CGObjCMacStatics.isWeakLinkedClass(ClassReceiver);
        // If we're emitting a method, and self is const (meaning just ARC, for now),
        // and the receiver is a load of self, then self is a valid object.
      } else {
        /*const*/ ObjCMethodDecl /*P*/ CurMethod = dyn_cast_or_null_ObjCMethodDecl(CGF.CurCodeDecl);
        if ((CurMethod != null)) {
          ImplicitParamDecl /*P*/ Self = CurMethod.getSelfDecl();
          if (Self.getType().isConstQualified()) {
            {
              LoadInst /*P*/ LI = dyn_cast_LoadInst(Arg0.stripPointerCasts());
              if ((LI != null)) {
                Value /*P*/ SelfAddr = CGF.GetAddrOfLocalVar(Self).getPointer();
                if (SelfAddr == LI.getPointerOperand()) {
                  ReceiverCanBeNull = false;
                }
              }
            }
          }
        }
      }
      
      NullReturnState nullReturn/*J*/= new NullReturnState();
      
      Constant /*P*/ Fn = null;
      if (CGM.ReturnSlotInterferesWithArgs(MSI.CallInfo)) {
        if (ReceiverCanBeNull) {
          nullReturn.init(CGF, Arg0);
        }
        Fn = (ObjCABI == 2) ? ObjCTypes.getSendStretFn2(IsSuper) : ObjCTypes.getSendStretFn(IsSuper);
      } else if (CGM.ReturnTypeUsesFPRet(new QualType(ResultType))) {
        Fn = (ObjCABI == 2) ? ObjCTypes.getSendFpretFn2(IsSuper) : ObjCTypes.getSendFpretFn(IsSuper);
      } else if (CGM.ReturnTypeUsesFP2Ret(new QualType(ResultType))) {
        Fn = (ObjCABI == 2) ? ObjCTypes.getSendFp2RetFn2(IsSuper) : ObjCTypes.getSendFp2retFn(IsSuper);
      } else {
        // arm64 uses objc_msgSend for stret methods and yet null receiver check
        // must be made for it.
        if (ReceiverCanBeNull && CGM.ReturnTypeUsesSRet(MSI.CallInfo)) {
          nullReturn.init(CGF, Arg0);
        }
        Fn = (ObjCABI == 2) ? ObjCTypes.getSendFn2(IsSuper) : ObjCTypes.getSendFn(IsSuper);
      }
      
      // Emit a null-check if there's a consumed argument other than the receiver.
      boolean RequiresNullCheck = false;
      if (ReceiverCanBeNull && CGM.getLangOpts().ObjCAutoRefCount && (Method != null)) {
        for (/*const*/ ParmVarDecl /*P*/ ParamDecl : Method.parameters()) {
          if (ParamDecl.hasAttr(NSConsumedAttr.class)) {
            if (!(nullReturn.NullBB != null)) {
              nullReturn.init(CGF, Arg0);
            }
            RequiresNullCheck = true;
            break;
          }
        }
      }
      
      type$ptr<Instruction /*P*/ > CallSite = create_type$null$ptr();
      Fn = ConstantExpr.getBitCast(Fn, MSI.MessengerType);
      RValue rvalue = CGF.EmitCall(MSI.CallInfo, Fn, new ReturnValueSlot(Return), ActualArgs, 
          new CGCalleeInfo(), $AddrOf(CallSite));
      
      // Mark the call as noreturn if the method is marked noreturn and the
      // receiver cannot be null.
      if ((Method != null) && Method.hasAttr(NoReturnAttr.class) && !ReceiverCanBeNull) {
        new CallSite(CallSite.$star()).setDoesNotReturn();
      }
      
      return nullReturn.complete(CGF, new RValue(rvalue), new QualType(ResultType), CallArgs, 
          RequiresNullCheck ? Method : (/*const*/ ObjCMethodDecl /*P*/ )null);
    } finally {
      if (ActualArgs != null) { ActualArgs.$destroy(); }
    }
  }

  
  /// EmitImageInfo - Emit the image info marker used to encode some module
  /// level information.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::EmitImageInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4525,
   FQN="(anonymous namespace)::CGObjCCommonMac::EmitImageInfo", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac13EmitImageInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac13EmitImageInfoEv")
  //</editor-fold>
  protected void EmitImageInfo() {
    /*uint*/int version = 0; // Version is unused?
    /*const*/char$ptr/*char P*/ Section = $tryClone((ObjCABI == 1) ? $("__OBJC, __image_info,regular") : $("__DATA, __objc_imageinfo, regular, no_dead_strip"));
    
    // Generate module-level named metadata to convey this information to the
    // linker and code-gen.
    final org.llvm.ir.Module /*&*/ Mod = CGM.getModule();
    
    // Add the ObjC ABI version to the module flags.
    Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"Objective-C Version"), ObjCABI);
    Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"Objective-C Image Info Version"), 
        version);
    Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"Objective-C Image Info Section"), 
        MDString.get(VMContext, Section));
    if (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
      // Non-GC overrides those files which specify GC.
      Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Override, 
          new StringRef(/*KEEP_STR*/"Objective-C Garbage Collection"), (/*uint32_t*/int)0);
    } else {
      // Add the ObjC garbage collection value.
      Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Error, 
          new StringRef(/*KEEP_STR*/"Objective-C Garbage Collection"), 
          ImageInfoFlags.eImageInfo_GarbageCollected);
      if (CGM.getLangOpts().getGC() == LangOptions.GCMode.GCOnly) {
        // Add the ObjC GC Only value.
        Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"Objective-C GC Only"), 
            ImageInfoFlags.eImageInfo_GCOnly);
        
        // Require that GC be specified and set to eImageInfo_GarbageCollected.
        Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {
          MDString.get(VMContext, $("Objective-C Garbage Collection")), 
          ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(VMContext), $uint2ulong(ImageInfoFlags.eImageInfo_GarbageCollected)))
        };
        Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Require, new StringRef(/*KEEP_STR*/"Objective-C GC Only"), 
            MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(Ops, true)));
      }
    }
    
    // Indicate whether we're compiling this to run on a simulator.
    final /*const*/ Triple /*&*/ $Triple = CGM.getTarget().getTriple();
    if (($Triple.isiOS() || $Triple.isWatchOS())
       && ($Triple.getArch() == Triple.ArchType.x86
       || $Triple.getArch() == Triple.ArchType.x86_64)) {
      Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"Objective-C Is Simulated"), 
          ImageInfoFlags.eImageInfo_ImageIsSimulated);
    }
    
    // Indicate whether we are generating class properties.
    Mod.addModuleFlag(org.llvm.ir.Module.ModFlagBehavior.Error, new StringRef(/*KEEP_STR*/"Objective-C Class Properties"), 
        ImageInfoFlags.eImageInfo_ClassProperties);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::CGObjCCommonMac">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1039,
   FQN="(anonymous namespace)::CGObjCCommonMac::CGObjCCommonMac", NM="_ZN12_GLOBAL__N_115CGObjCCommonMacC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMacC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public CGObjCCommonMac(final CodeGenModule /*&*/ cgm) {
    // : CGObjCRuntime(cgm), VMContext(cgm.getLLVMContext()), RunSkipBlockVars(), LazySymbols(), DefinedSymbols(), ClassNames(), MethodVarNames(), DefinedCategoryNames(), MethodVarTypes(), MethodDefinitions(), PropertyNames(), ClassReferences(), SelectorReferences(), Protocols(), DefinedProtocols(), DefinedClasses(), ImplementedClasses(), DefinedNonLazyClasses(), DefinedCategories(), DefinedNonLazyCategories() 
    //START JInit
    super(cgm);
    this./*&*/VMContext=/*&*/cgm.getLLVMContext();
    this.RunSkipBlockVars = new SmallVector<RUN_SKIP>(16, new RUN_SKIP());
    this.LazySymbols = new SetVector<IdentifierInfo /*P*/ >((IdentifierInfo /*P*/ )null);
    this.DefinedSymbols = new SetVector<IdentifierInfo /*P*/ >((IdentifierInfo /*P*/ )null);
    this.ClassNames = new StringMap<GlobalVariable /*P*/ >((GlobalVariable /*P*/ )null);
    this.MethodVarNames = new DenseMap<Selector, GlobalVariable /*P*/ >(DenseMapInfoSelector.$Info(), (GlobalVariable /*P*/ )null);
    this.DefinedCategoryNames = new SmallSetVector<std.string>(16, std.string.EMPTY);
    this.MethodVarTypes = new StringMap<GlobalVariable /*P*/ >((GlobalVariable /*P*/ )null);
    this.MethodDefinitions = new DenseMap</*const*/ ObjCMethodDecl /*P*/ , Function /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Function /*P*/ )null);
    this.PropertyNames = new DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.ClassReferences = new DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.SelectorReferences = new DenseMap<Selector, GlobalVariable /*P*/ >(DenseMapInfoSelector.$Info(), (GlobalVariable /*P*/ )null);
    this.Protocols = new DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.DefinedProtocols = new DenseSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.DefinedClasses = new SmallVector<GlobalValue /*P*/ >(16, (GlobalValue /*P*/ )null);
    this.ImplementedClasses = new SmallVector</*const*/ ObjCInterfaceDecl /*P*/ >(16, (/*const*/ ObjCInterfaceDecl /*P*/ )null);
    this.DefinedNonLazyClasses = new SmallVector<GlobalValue /*P*/ >(16, (GlobalValue /*P*/ )null);
    this.DefinedCategories = new SmallVector<GlobalValue /*P*/ >(16, (GlobalValue /*P*/ )null);
    this.DefinedNonLazyCategories = new SmallVector<GlobalValue /*P*/ >(16, (GlobalValue /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::isNonFragileABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1042,
   FQN="(anonymous namespace)::CGObjCCommonMac::isNonFragileABI", NM="_ZNK12_GLOBAL__N_115CGObjCCommonMac15isNonFragileABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_115CGObjCCommonMac15isNonFragileABIEv")
  //</editor-fold>
  public boolean isNonFragileABI() /*const*/ {
    return ObjCABI == 2;
  }

  
  
  /// Generate a constant CFString object.
  /*
  struct __builtin_CFString {
  const int *isa; // point to __CFConstantStringClassReference
  int flags;
  const char *str;
  long length;
  };
  */
  
  /// or Generate a constant NSString object.
  /*
  struct __builtin_NSString {
  const int *isa; // point to __NSConstantStringClassReference
  const char *str;
  unsigned int length;
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GenerateConstantString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1764,
   FQN="(anonymous namespace)::CGObjCCommonMac::GenerateConstantString", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac22GenerateConstantStringEPKN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac22GenerateConstantStringEPKN5clang13StringLiteralE")
  //</editor-fold>
  @Override public ConstantAddress GenerateConstantString(/*const*/ StringLiteral /*P*/ SL)/* override*/ {
    return (CGM.getLangOpts().NoConstantCFStrings == false ? CGM.GetAddrOfConstantCFString(SL) : CGM.GetAddrOfConstantString(SL));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GenerateMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3618,
   FQN="(anonymous namespace)::CGObjCCommonMac::GenerateMethod", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac14GenerateMethodEPKN5clang14ObjCMethodDeclEPKNS1_17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac14GenerateMethodEPKN5clang14ObjCMethodDeclEPKNS1_17ObjCContainerDeclE")
  //</editor-fold>
  @Override public Function /*P*/ GenerateMethod(/*const*/ ObjCMethodDecl /*P*/ OMD)/* override*/ {
    return GenerateMethod(OMD, 
                (/*const*/ ObjCContainerDecl /*P*/ )null);
  }
  @Override public Function /*P*/ GenerateMethod(/*const*/ ObjCMethodDecl /*P*/ OMD, 
                /*const*/ ObjCContainerDecl /*P*/ CD/*= null*/)/* override*/ {
    SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
    GetNameForMethod(OMD, CD, Name);
    
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    org.llvm.ir.FunctionType /*P*/ MethodTy = Types.GetFunctionType(Types.arrangeObjCMethodDeclaration(OMD));
    Function /*P*/ Method = Function.Create(MethodTy, 
        GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(Name.str()), 
        $AddrOf(CGM.getModule()));
    MethodDefinitions.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(OMD, Method));
    
    return Method;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GenerateProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2667,
   FQN="(anonymous namespace)::CGObjCCommonMac::GenerateProtocol", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16GenerateProtocolEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16GenerateProtocolEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public void GenerateProtocol(/*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    // FIXME: We shouldn't need this, the protocol decl should contain enough
    // information to tell us whether this was a declaration or a definition.
    DefinedProtocols.insert(PD.getIdentifier());
    
    // If we have generated a forward reference to this protocol, emit
    // it now. Otherwise do nothing, the protocol objects are lazily
    // emitted.
    if ((Protocols.count(PD.getIdentifier()) != 0)) {
      GetOrEmitProtocol(PD);
    }
  }

  
  /// GetOrEmitProtocol - Get the protocol object for the given
  /// declaration, emitting it if necessary. The return value has type
  /// ProtocolPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetOrEmitProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1056,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetOrEmitProtocol", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac17GetOrEmitProtocolEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac17GetOrEmitProtocolEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetOrEmitProtocol(/*const*/ ObjCProtocolDecl /*P*/ PD)/* = 0*/;

  
  /// GetOrEmitProtocolRef - Get a forward reference to the protocol
  /// object for the given declaration, emitting it if needed. These
  /// forward references will be filled in with empty bodies if no
  /// definition is seen. The return value has type ProtocolPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::GetOrEmitProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1062,
   FQN="(anonymous namespace)::CGObjCCommonMac::GetOrEmitProtocolRef", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac20GetOrEmitProtocolRefEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac20GetOrEmitProtocolRefEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetOrEmitProtocolRef(/*const*/ ObjCProtocolDecl /*P*/ PD)/* = 0*/;

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildGCBlockLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2075,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildGCBlockLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac18BuildGCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac18BuildGCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE")
  //</editor-fold>
  @Override public Constant /*P*/ BuildGCBlockLayout(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ CGBlockInfo /*&*/ blockInfo)/* override*/ {
    IvarLayoutBuilder builder = null;
    try {
      
      Constant /*P*/ nullPtr = Constant.getNullValue(CGM.Unnamed_field9.Int8PtrTy);
      if (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
        return nullPtr;
      }
      
      builder/*J*/= new IvarLayoutBuilder(CGM, CharUnits.Zero(), new CharUnits(blockInfo.BlockSize), 
          /*for strong layout*/ true);
      
      builder.visitBlock(blockInfo);
      if (!builder.hasBitmapData()) {
        return nullPtr;
      }
      
      SmallVectorUChar buffer/*J*/= new SmallVectorUChar(32, (/*uchar*/byte)0);
      Constant /*P*/ C = builder.buildBitmap(/*Deref*/this, buffer);
      if (CGM.getLangOpts().ObjCGCBitmapPrint && !buffer.empty()) {
        printf(/*KEEP_STR*/"\n block variable layout for block: ");
        builder.dump(new ArrayRefUChar(buffer));
      }
      
      return C;
    } finally {
      if (builder != null) { builder.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildRCBlockLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2586,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildRCBlockLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac18BuildRCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac18BuildRCBlockLayoutERN5clang7CodeGen13CodeGenModuleERKNS2_11CGBlockInfoE")
  //</editor-fold>
  @Override public Constant /*P*/ BuildRCBlockLayout(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ CGBlockInfo /*&*/ blockInfo)/* override*/ {
    assert (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC);
    
    RunSkipBlockVars.clear();
    bool$ref hasUnion = create_bool$ref(false);
    
    /*uint*/int WordSizeInBits = $ulong2uint(CGM.getTarget().getPointerWidth(0));
    /*uint*/int ByteSizeInBits = CGM.getTarget().getCharWidth();
    /*uint*/int WordSizeInBytes = $div_uint(WordSizeInBits, ByteSizeInBits);
    
    /*const*/ BlockDecl /*P*/ blockDecl = blockInfo.getBlockDecl();
    
    // Calculate the basic layout of the block structure.
    /*const*/ StructLayout /*P*/ layout = CGM.getDataLayout().getStructLayout(blockInfo.StructureType);
    
    // Ignore the optional 'this' capture: C++ objects are not assumed
    // to be GC'ed.
    if (blockInfo.BlockHeaderForcedGapSize.$noteq(CharUnits.Zero())) {
      UpdateRunSkipBlockVars(false, Qualifiers.ObjCLifetime.OCL_None, 
          new CharUnits(blockInfo.BlockHeaderForcedGapOffset), 
          new CharUnits(blockInfo.BlockHeaderForcedGapSize));
    }
    // Walk the captured variables.
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : blockDecl.captures()) {
      /*const*/ VarDecl /*P*/ variable = CI.getVariable();
      QualType type = variable.getType();
      
      final /*const*/ CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture$Const(variable);
      
      // Ignore constant captures.
      if (capture.isConstant()) {
        continue;
      }
      
      CharUnits fieldOffset = CharUnits.fromQuantity(layout.getElementOffset(capture.getIndex()));
      assert (!type.$arrow().isArrayType()) : "array variable should not be caught";
      if (!CI.isByRef()) {
        {
          /*const*/ RecordType /*P*/ record = type.$arrow().getAs$RecordType();
          if ((record != null)) {
            BuildRCBlockVarRecordLayout(record, new CharUnits(fieldOffset), hasUnion);
            continue;
          }
        }
      }
      CharUnits fieldSize/*J*/= new CharUnits();
      if (CI.isByRef()) {
        fieldSize.$assignMove(CharUnits.fromQuantity($uint2long(WordSizeInBytes)));
      } else {
        fieldSize.$assignMove(CGM.getContext().getTypeSizeInChars(/*NO_COPY*/type));
      }
      UpdateRunSkipBlockVars(CI.isByRef(), getBlockCaptureLifetime(new QualType(type), false), 
          new CharUnits(fieldOffset), new CharUnits(fieldSize));
    }
    return getBitmapBlockLayout(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::BuildByrefLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2639,
   FQN="(anonymous namespace)::CGObjCCommonMac::BuildByrefLayout", NM="_ZN12_GLOBAL__N_115CGObjCCommonMac16BuildByrefLayoutERN5clang7CodeGen13CodeGenModuleENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMac16BuildByrefLayoutERN5clang7CodeGen13CodeGenModuleENS1_8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ BuildByrefLayout(final CodeGenModule /*&*/ CGM, 
                  QualType T)/* override*/ {
    assert (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC);
    assert (!T.$arrow().isArrayType()) : "__block array variable should not be caught";
    CharUnits fieldOffset/*J*/= new CharUnits();
    RunSkipBlockVars.clear();
    bool$ref hasUnion = create_bool$ref(false);
    {
      /*const*/ RecordType /*P*/ record = T.$arrow().getAs$RecordType();
      if ((record != null)) {
        BuildRCBlockVarRecordLayout(record, new CharUnits(fieldOffset), hasUnion, true/*ByrefLayout */);
        Constant /*P*/ Result = getBitmapBlockLayout(true);
        if (isa_ConstantInt(Result)) {
          Result = ConstantExpr.getIntToPtr(Result, CGM.Unnamed_field9.Int8PtrTy);
        }
        return Result;
      }
    }
    Constant /*P*/ nullPtr = Constant.getNullValue(CGM.Unnamed_field9.Int8PtrTy);
    return nullPtr;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCCommonMac::~CGObjCCommonMac">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 736,
   FQN="(anonymous namespace)::CGObjCCommonMac::~CGObjCCommonMac", NM="_ZN12_GLOBAL__N_115CGObjCCommonMacD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115CGObjCCommonMacD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DefinedNonLazyCategories.$destroy();
    DefinedCategories.$destroy();
    DefinedNonLazyClasses.$destroy();
    ImplementedClasses.$destroy();
    DefinedClasses.$destroy();
    DefinedProtocols.$destroy();
    Protocols.$destroy();
    SelectorReferences.$destroy();
    ClassReferences.$destroy();
    PropertyNames.$destroy();
    MethodDefinitions.$destroy();
    MethodVarTypes.$destroy();
    DefinedCategoryNames.$destroy();
    MethodVarNames.$destroy();
    ClassNames.$destroy();
    DefinedSymbols.$destroy();
    LazySymbols.$destroy();
    RunSkipBlockVars.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "VMContext=" + "[LLVMContext]" // NOI18N
              + ", ObjCABI=" + ObjCABI // NOI18N
              + ", RunSkipBlockVars=" + RunSkipBlockVars // NOI18N
              + ", LazySymbols=" + LazySymbols // NOI18N
              + ", DefinedSymbols=" + DefinedSymbols // NOI18N
              + ", ClassNames=" + ClassNames // NOI18N
              + ", MethodVarNames=" + MethodVarNames // NOI18N
              + ", DefinedCategoryNames=" + DefinedCategoryNames // NOI18N
              + ", MethodVarTypes=" + MethodVarTypes // NOI18N
              + ", MethodDefinitions=" + MethodDefinitions // NOI18N
              + ", PropertyNames=" + PropertyNames // NOI18N
              + ", ClassReferences=" + ClassReferences // NOI18N
              + ", SelectorReferences=" + SelectorReferences // NOI18N
              + ", Protocols=" + Protocols // NOI18N
              + ", DefinedProtocols=" + DefinedProtocols // NOI18N
              + ", DefinedClasses=" + DefinedClasses // NOI18N
              + ", ImplementedClasses=" + "[SmallVector$ObjCInterfaceDecl]" // NOI18N
              + ", DefinedNonLazyClasses=" + DefinedNonLazyClasses // NOI18N
              + ", DefinedCategories=" + DefinedCategories // NOI18N
              + ", DefinedNonLazyCategories=" + DefinedNonLazyCategories // NOI18N
              + super.toString(); // NOI18N
  }
}
