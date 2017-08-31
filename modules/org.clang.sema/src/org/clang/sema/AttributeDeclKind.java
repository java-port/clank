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


/// These constants match the enumerated choices of
/// warn_attribute_wrong_decl_type and err_attribute_wrong_decl_type.
//<editor-fold defaultstate="collapsed" desc="clang::AttributeDeclKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 868,
 FQN="clang::AttributeDeclKind", NM="_ZN5clang17AttributeDeclKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang17AttributeDeclKindE")
//</editor-fold>
public enum AttributeDeclKind implements Native.ComparableLower, Native.NativeUIntEnum {
  ExpectedFunction(0),
  ExpectedUnion(ExpectedFunction.getValue() + 1),
  ExpectedVariableOrFunction(ExpectedUnion.getValue() + 1),
  ExpectedFunctionVariableOrObjCInterface(ExpectedVariableOrFunction.getValue() + 1),
  ExpectedFunctionOrMethod(ExpectedFunctionVariableOrObjCInterface.getValue() + 1),
  ExpectedParameter(ExpectedFunctionOrMethod.getValue() + 1),
  ExpectedFunctionMethodOrBlock(ExpectedParameter.getValue() + 1),
  ExpectedFunctionMethodOrClass(ExpectedFunctionMethodOrBlock.getValue() + 1),
  ExpectedFunctionMethodOrParameter(ExpectedFunctionMethodOrClass.getValue() + 1),
  ExpectedClass(ExpectedFunctionMethodOrParameter.getValue() + 1),
  ExpectedEnum(ExpectedClass.getValue() + 1),
  ExpectedVariable(ExpectedEnum.getValue() + 1),
  ExpectedMethod(ExpectedVariable.getValue() + 1),
  ExpectedFieldOrGlobalVar(ExpectedMethod.getValue() + 1),
  ExpectedStruct(ExpectedFieldOrGlobalVar.getValue() + 1),
  ExpectedParameterOrTypedef(ExpectedStruct.getValue() + 1),
  ExpectedVariableOrTypedef(ExpectedParameterOrTypedef.getValue() + 1),
  ExpectedTLSVar(ExpectedVariableOrTypedef.getValue() + 1),
  ExpectedVariableOrField(ExpectedTLSVar.getValue() + 1),
  ExpectedVariableFieldOrTag(ExpectedVariableOrField.getValue() + 1),
  ExpectedTypeOrNamespace(ExpectedVariableFieldOrTag.getValue() + 1),
  ExpectedObjectiveCInterface(ExpectedTypeOrNamespace.getValue() + 1),
  ExpectedMethodOrProperty(ExpectedObjectiveCInterface.getValue() + 1),
  ExpectedStructOrUnion(ExpectedMethodOrProperty.getValue() + 1),
  ExpectedStructOrUnionOrClass(ExpectedStructOrUnion.getValue() + 1),
  ExpectedType(ExpectedStructOrUnionOrClass.getValue() + 1),
  ExpectedObjCInstanceMethod(ExpectedType.getValue() + 1),
  ExpectedObjCInterfaceDeclInitMethod(ExpectedObjCInstanceMethod.getValue() + 1),
  ExpectedFunctionVariableOrClass(ExpectedObjCInterfaceDeclInitMethod.getValue() + 1),
  ExpectedFunctionVariableClassOrObjCInterface(ExpectedFunctionVariableOrClass.getValue() + 1),
  ExpectedObjectiveCProtocol(ExpectedFunctionVariableClassOrObjCInterface.getValue() + 1),
  ExpectedFunctionGlobalVarMethodOrProperty(ExpectedObjectiveCProtocol.getValue() + 1),
  ExpectedStructOrUnionOrTypedef(ExpectedFunctionGlobalVarMethodOrProperty.getValue() + 1),
  ExpectedStructOrTypedef(ExpectedStructOrUnionOrTypedef.getValue() + 1),
  ExpectedObjectiveCInterfaceOrProtocol(ExpectedStructOrTypedef.getValue() + 1),
  ExpectedKernelFunction(ExpectedObjectiveCInterfaceOrProtocol.getValue() + 1),
  ExpectedFunctionWithProtoType(ExpectedKernelFunction.getValue() + 1),
  ExpectedVariableEnumFieldOrTypedef(ExpectedFunctionWithProtoType.getValue() + 1),
  ExpectedFunctionMethodEnumOrClass(ExpectedVariableEnumFieldOrTypedef.getValue() + 1),
  ExpectedStructClassVariableFunctionOrInlineNamespace(ExpectedFunctionMethodEnumOrClass.getValue() + 1),
  ExpectedForMaybeUnused(ExpectedStructClassVariableFunctionOrInlineNamespace.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AttributeDeclKind valueOf(int val) {
    AttributeDeclKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AttributeDeclKind[] VALUES;
    private static final AttributeDeclKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AttributeDeclKind kind : AttributeDeclKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AttributeDeclKind[min < 0 ? (1-min) : 0];
      VALUES = new AttributeDeclKind[max >= 0 ? (1+max) : 0];
      for (AttributeDeclKind kind : AttributeDeclKind.values()) {
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
  private AttributeDeclKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AttributeDeclKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AttributeDeclKind)obj).value);}
  //</editor-fold>
}
