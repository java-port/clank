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

package org.clang.codegen.CodeGen;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.basic.CallingConv;
import org.clang.ast.FunctionType;
import static org.clank.support.NativePointer.create_type$ptr;
import static org.clank.support.NativePointer.new$Object;
import org.llvm.adt.java.TrailingObjectsUtils;


/// CGFunctionInfo - Class to encapsulate the information about a
/// function definition.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 448,
 FQN="clang::CodeGen::CGFunctionInfo", NM="_ZN5clang7CodeGen14CGFunctionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfoE")
//</editor-fold>
public final class CGFunctionInfo extends /*public*/ FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, 
        /*private*/ TrailingObjects2<CGFunctionInfo, CGFunctionInfoArgInfo, FunctionProtoType.ExtParameterInfo>, ITrailingObjectsJavaBase<CGFunctionInfo> {
  // JAVA: typedef CGFunctionInfoArgInfo ArgInfo
//  public final class ArgInfo extends CGFunctionInfoArgInfo{ };
  // JAVA: typedef FunctionProtoType::ExtParameterInfo ExtParameterInfo
//  public final class ExtParameterInfo extends FunctionProtoType.ExtParameterInfo{ };
  
  /// The LLVM::CallingConv to use for this function (as specified by the
  /// user).
  private /*JBYTE unsigned int*/ byte CallingConvention /*: 8*/;
  
  /// The LLVM::CallingConv to actually use for this function, which may
  /// depend on the ABI.
  private /*JBYTE unsigned int*/ byte EffectiveCallingConvention /*: 8*/;
  
  /// The clang::CallingConv that this was originally created with.
  private /*JBYTE unsigned int*/ byte ASTCallingConvention /*: 8*/;
  
  /// Whether this is an instance method.
  private /*JBIT unsigned int*/ boolean InstanceMethod /*: 1*/;
  
  /// Whether this is a chain call.
  private /*JBIT unsigned int*/ boolean ChainCall /*: 1*/;
  
  /// Whether this function is noreturn.
  private /*JBIT unsigned int*/ boolean NoReturn /*: 1*/;
  
  /// Whether this function is returns-retained.
  private /*JBIT unsigned int*/ boolean ReturnsRetained /*: 1*/;
  
  /// How many arguments to pass inreg.
  private /*JBIT unsigned int*/ boolean HasRegParm /*: 1*/;
  private /*JBYTE unsigned int*/ byte RegParm /*: 3*/;
  
  private RequiredArgs Required;
  
  /// The struct representing all arguments passed in memory.  Only used when
  /// passing non-trivial types with inalloca.  Not part of the profile.
  private StructType /*P*/ ArgStruct;
  private /*uint*/int ArgStructAlign /*: 31*/;
  private /*JBIT unsigned int*/ boolean HasExtParameterInfos /*: 1*/;
  
  private /*uint*/int NumArgs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getArgsBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 492,
   FQN="clang::CodeGen::CGFunctionInfo::getArgsBuffer", NM="_ZN5clang7CodeGen14CGFunctionInfo13getArgsBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo13getArgsBufferEv")
  //</editor-fold>
  private type$ptr<CGFunctionInfoArgInfo> /*P*/  getArgsBuffer() {
    return getTrailingObjects(CGFunctionInfoArgInfo.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getArgsBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 495,
   FQN="clang::CodeGen::CGFunctionInfo::getArgsBuffer", NM="_ZNK5clang7CodeGen14CGFunctionInfo13getArgsBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo13getArgsBufferEv")
  //</editor-fold>
  private /*const*/ type$ptr<CGFunctionInfoArgInfo> /*P*/  getArgsBuffer$Const() /*const*/ {
    return getTrailingObjects$Const(CGFunctionInfoArgInfo.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getExtParameterInfosBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 499,
   FQN="clang::CodeGen::CGFunctionInfo::getExtParameterInfosBuffer", NM="_ZN5clang7CodeGen14CGFunctionInfo26getExtParameterInfosBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo26getExtParameterInfosBufferEv")
  //</editor-fold>
  private type$ptr<FunctionProtoType.ExtParameterInfo> /*P*/  getExtParameterInfosBuffer() {
    return getTrailingObjects(FunctionProtoType.ExtParameterInfo.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getExtParameterInfosBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 502,
   FQN="clang::CodeGen::CGFunctionInfo::getExtParameterInfosBuffer", NM="_ZNK5clang7CodeGen14CGFunctionInfo26getExtParameterInfosBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo26getExtParameterInfosBufferEv")
  //</editor-fold>
  private /*const*/ type$ptr<FunctionProtoType.ExtParameterInfo> /*P*/  getExtParameterInfosBuffer$Const() /*const*/ {
    return getTrailingObjects$Const(FunctionProtoType.ExtParameterInfo.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::CGFunctionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 506,
   FQN="clang::CodeGen::CGFunctionInfo::CGFunctionInfo", NM="_ZN5clang7CodeGen14CGFunctionInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfoC1Ev")
  //</editor-fold>
  private CGFunctionInfo() {
    // : FoldingSetNode(), TrailingObjects<CGFunctionInfo, CGFunctionInfoArgInfo, FunctionProtoType::ExtParameterInfo>(), Required(RequiredArgs::All) 
    //START JInit
    $Node();
    $TrailingObjects();
    this.Required = new RequiredArgs(RequiredArgs.All_t.All);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 727,
   FQN="clang::CodeGen::CGFunctionInfo::create", NM="_ZN5clang7CodeGen14CGFunctionInfo6createEjbbRKNS_12FunctionType7ExtInfoEN4llvm8ArrayRefINS_17FunctionProtoType16ExtParameterInfoEEENS_7CanQualINS_4TypeEEENS7_ISD_EENS0_12RequiredArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo6createEjbbRKNS_12FunctionType7ExtInfoEN4llvm8ArrayRefINS_17FunctionProtoType16ExtParameterInfoEEENS_7CanQualINS_4TypeEEENS7_ISD_EENS0_12RequiredArgsE")
  //</editor-fold>
  public static CGFunctionInfo /*P*/ create(/*uint*/int llvmCC, 
        boolean instanceMethod, 
        boolean chainCall, 
        final /*const*/ FunctionType.ExtInfo /*&*/ info, 
        ArrayRef<FunctionProtoType.ExtParameterInfo> paramInfos, 
        CanQual<org.clang.ast.Type> resultType, 
        ArrayRef<CanQual<org.clang.ast.Type>> argTypes, 
        RequiredArgs required) {
    assert (paramInfos.empty() || paramInfos.size() == argTypes.size());
    
    // JAVA: Alloc
    type$ptr/*void P*/ buffer = create_type$ptr(new$Object(TrailingObjects.totalSizeToAlloc$Same(CGFunctionInfoArgInfo.class, FunctionProtoType.ExtParameterInfo.class, argTypes.size() + 1, paramInfos.size())));
    // initialize trailings
    int offset = 1; // this
    for (int i = 0; i < argTypes.size() + 1; i++) {
      buffer.$set(offset + i, new CGFunctionInfoArgInfo());
    }
    offset += argTypes.size() + 1;
    for (int i = 0; i < paramInfos.size(); i++) {
      buffer.$set(offset + i, new CGFunctionInfoArgInfo());
    }
    // JAVA: Alloc
    CGFunctionInfo /*P*/ FI = ((/*JCast*/CGFunctionInfo /*P*/ )(/*NEW_EXPR [System]*//*buffer = *//*new (buffer)*/ TrailingObjectsUtils.$new_uint_voidPtr(buffer, (type$ptr<?> New$Mem)->{
        assert New$Mem.$eq(buffer);
        return new CGFunctionInfo();
     })));
    FI.CallingConvention = $uint2uint_8bits(llvmCC);
    FI.EffectiveCallingConvention = $uint2uint_8bits(llvmCC);
    FI.ASTCallingConvention = $uint2uint_8bits(info.getCC().getValue());
    FI.InstanceMethod = instanceMethod;
    FI.ChainCall = chainCall;
    FI.NoReturn = info.getNoReturn();
    FI.ReturnsRetained = info.getProducesResult();
    FI.Required.$assign(required);
    FI.HasRegParm = info.getHasRegParm();
    FI.RegParm = $uint2uint_3bits(info.getRegParm());
    FI.ArgStruct = null;
    FI.ArgStructAlign = 0;
    FI.NumArgs = argTypes.size();
    FI.HasExtParameterInfos = !paramInfos.empty();
    FI.getArgsBuffer().$star().type.$assign(resultType);
    for (/*uint*/int i = 0, e = argTypes.size(); i != e; ++i)  {
      FI.getArgsBuffer().$at(i + 1).type.$assign(argTypes.$at(i));
    }
    for (/*uint*/int i = 0, e = paramInfos.size(); i != e; ++i)  {
      FI.getExtParameterInfosBuffer().$at(i).$assign(paramInfos.$at(i));
    }
    return FI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::operator delete">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 517,
   FQN="clang::CodeGen::CGFunctionInfo::operator delete", NM="_ZN5clang7CodeGen14CGFunctionInfodlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfodlEPv")
  //</editor-fold>
  public static void $delete(Object/*void P*/ p) {
    /*::*///$delete_voidPtr(p);
  }

  
  // Friending class TrailingObjects is apparently not good enough for MSVC,
  // so these have to be public.
  /*friend  class TrailingObjects<CGFunctionInfo, CGFunctionInfoArgInfo, ExtParameterInfo>*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::numTrailingObjects">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 522,
   FQN="clang::CodeGen::CGFunctionInfo::numTrailingObjects", NM="_ZNK5clang7CodeGen14CGFunctionInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS0_21CGFunctionInfoArgInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS0_21CGFunctionInfoArgInfoEEE")
  //</editor-fold>
  public /*size_t*/int numTrailingObjects_OverloadToken$CGFunctionInfoArgInfo(TrailingObjects2.OverloadToken<CGFunctionInfoArgInfo> $Prm0) /*const*/ {
    return NumArgs + 1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::numTrailingObjects">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 525,
   FQN="clang::CodeGen::CGFunctionInfo::numTrailingObjects", NM="_ZNK5clang7CodeGen14CGFunctionInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_17FunctionProtoType16ExtParameterInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_17FunctionProtoType16ExtParameterInfoEEE")
  //</editor-fold>
  public /*size_t*/int numTrailingObjects_OverloadToken$ExtParameterInfo(TrailingObjects2.OverloadToken<FunctionProtoType.ExtParameterInfo> $Prm0) /*const*/ {
    return (HasExtParameterInfos ? NumArgs : 0);
  }

  
  // JAVA: typedef const ArgInfo *const_arg_iterator
//  public final class const_arg_iterator extends /*const*/ CGFunctionInfoArgInfo /*P*/ { };
  // JAVA: typedef ArgInfo *arg_iterator
//  public final class arg_iterator extends CGFunctionInfoArgInfo /*P*/ { };
  
  // JAVA: typedef llvm::iterator_range<arg_iterator> arg_range
//  public final class arg_range extends iterator_range<CGFunctionInfoArgInfo>{ };
  // JAVA: typedef llvm::iterator_range<const_arg_iterator> arg_const_range
//  public final class arg_const_range extends iterator_range</*const*/ CGFunctionInfoArgInfo>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 535,
   FQN="clang::CodeGen::CGFunctionInfo::arguments", NM="_ZN5clang7CodeGen14CGFunctionInfo9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo9argumentsEv")
  //</editor-fold>
  public iterator_range<CGFunctionInfoArgInfo> arguments() {
    return new iterator_range<CGFunctionInfoArgInfo>(arg_begin(), arg_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 536,
   FQN="clang::CodeGen::CGFunctionInfo::arguments", NM="_ZNK5clang7CodeGen14CGFunctionInfo9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo9argumentsEv")
  //</editor-fold>
  public iterator_range</*const*/ CGFunctionInfoArgInfo> arguments$Const() /*const*/ {
    return new iterator_range</*const*/ CGFunctionInfoArgInfo>(arg_begin$Const(), arg_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 540,
   FQN="clang::CodeGen::CGFunctionInfo::arg_begin", NM="_ZNK5clang7CodeGen14CGFunctionInfo9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo9arg_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > arg_begin$Const() /*const*/ {
    return getArgsBuffer$Const().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::arg_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 541,
   FQN="clang::CodeGen::CGFunctionInfo::arg_end", NM="_ZNK5clang7CodeGen14CGFunctionInfo7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo7arg_endEv")
  //</editor-fold>
  public type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > arg_end$Const() /*const*/ {
    return getArgsBuffer$Const().$add(1 + NumArgs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::arg_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 542,
   FQN="clang::CodeGen::CGFunctionInfo::arg_begin", NM="_ZN5clang7CodeGen14CGFunctionInfo9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo9arg_beginEv")
  //</editor-fold>
  public type$ptr<CGFunctionInfoArgInfo /*P*/ > arg_begin() {
    return getArgsBuffer().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::arg_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 543,
   FQN="clang::CodeGen::CGFunctionInfo::arg_end", NM="_ZN5clang7CodeGen14CGFunctionInfo7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo7arg_endEv")
  //</editor-fold>
  public type$ptr<CGFunctionInfoArgInfo /*P*/ > arg_end() {
    return getArgsBuffer().$add(1 + NumArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::arg_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 545,
   FQN="clang::CodeGen::CGFunctionInfo::arg_size", NM="_ZNK5clang7CodeGen14CGFunctionInfo8arg_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo8arg_sizeEv")
  //</editor-fold>
  public /*uint*/int arg_size() /*const*/ {
    return NumArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::isVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 547,
   FQN="clang::CodeGen::CGFunctionInfo::isVariadic", NM="_ZNK5clang7CodeGen14CGFunctionInfo10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo10isVariadicEv")
  //</editor-fold>
  public boolean isVariadic() /*const*/ {
    return Required.allowsOptionalArgs();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getRequiredArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 548,
   FQN="clang::CodeGen::CGFunctionInfo::getRequiredArgs", NM="_ZNK5clang7CodeGen14CGFunctionInfo15getRequiredArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo15getRequiredArgsEv")
  //</editor-fold>
  public RequiredArgs getRequiredArgs() /*const*/ {
    return new RequiredArgs(Required);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getNumRequiredArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 549,
   FQN="clang::CodeGen::CGFunctionInfo::getNumRequiredArgs", NM="_ZNK5clang7CodeGen14CGFunctionInfo18getNumRequiredArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo18getNumRequiredArgsEv")
  //</editor-fold>
  public /*uint*/int getNumRequiredArgs() /*const*/ {
    return isVariadic() ? getRequiredArgs().getNumRequiredArgs() : arg_size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::isInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 553,
   FQN="clang::CodeGen::CGFunctionInfo::isInstanceMethod", NM="_ZNK5clang7CodeGen14CGFunctionInfo16isInstanceMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo16isInstanceMethodEv")
  //</editor-fold>
  public boolean isInstanceMethod() /*const*/ {
    return InstanceMethod;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::isChainCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 555,
   FQN="clang::CodeGen::CGFunctionInfo::isChainCall", NM="_ZNK5clang7CodeGen14CGFunctionInfo11isChainCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo11isChainCallEv")
  //</editor-fold>
  public boolean isChainCall() /*const*/ {
    return ChainCall;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::isNoReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 557,
   FQN="clang::CodeGen::CGFunctionInfo::isNoReturn", NM="_ZNK5clang7CodeGen14CGFunctionInfo10isNoReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo10isNoReturnEv")
  //</editor-fold>
  public boolean isNoReturn() /*const*/ {
    return NoReturn;
  }

  
  /// In ARC, whether this function retains its return value.  This
  /// is not always reliable for call sites.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::isReturnsRetained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 561,
   FQN="clang::CodeGen::CGFunctionInfo::isReturnsRetained", NM="_ZNK5clang7CodeGen14CGFunctionInfo17isReturnsRetainedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo17isReturnsRetainedEv")
  //</editor-fold>
  public boolean isReturnsRetained() /*const*/ {
    return ReturnsRetained;
  }

  
  /// getASTCallingConvention() - Return the AST-specified calling
  /// convention.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getASTCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 565,
   FQN="clang::CodeGen::CGFunctionInfo::getASTCallingConvention", NM="_ZNK5clang7CodeGen14CGFunctionInfo23getASTCallingConventionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo23getASTCallingConventionEv")
  //</editor-fold>
  public CallingConv getASTCallingConvention() /*const*/ {
    return CallingConv.valueOf($8bits_uint2uint(ASTCallingConvention));
  }

  
  /// getCallingConvention - Return the user specified calling
  /// convention, which has been translated into an LLVM CC.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 571,
   FQN="clang::CodeGen::CGFunctionInfo::getCallingConvention", NM="_ZNK5clang7CodeGen14CGFunctionInfo20getCallingConventionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo20getCallingConventionEv")
  //</editor-fold>
  public /*uint*/int getCallingConvention() /*const*/ {
    return $8bits_uint2uint(CallingConvention);
  }

  
  /// getEffectiveCallingConvention - Return the actual calling convention to
  /// use, which may depend on the ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getEffectiveCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 575,
   FQN="clang::CodeGen::CGFunctionInfo::getEffectiveCallingConvention", NM="_ZNK5clang7CodeGen14CGFunctionInfo29getEffectiveCallingConventionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo29getEffectiveCallingConventionEv")
  //</editor-fold>
  public /*uint*/int getEffectiveCallingConvention() /*const*/ {
    return $8bits_uint2uint(EffectiveCallingConvention);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::setEffectiveCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 578,
   FQN="clang::CodeGen::CGFunctionInfo::setEffectiveCallingConvention", NM="_ZN5clang7CodeGen14CGFunctionInfo29setEffectiveCallingConventionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo29setEffectiveCallingConventionEj")
  //</editor-fold>
  public void setEffectiveCallingConvention(/*uint*/int Value) {
    EffectiveCallingConvention = $uint2uint_8bits(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getHasRegParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 582,
   FQN="clang::CodeGen::CGFunctionInfo::getHasRegParm", NM="_ZNK5clang7CodeGen14CGFunctionInfo13getHasRegParmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo13getHasRegParmEv")
  //</editor-fold>
  public boolean getHasRegParm() /*const*/ {
    return HasRegParm;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getRegParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 583,
   FQN="clang::CodeGen::CGFunctionInfo::getRegParm", NM="_ZNK5clang7CodeGen14CGFunctionInfo10getRegParmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo10getRegParmEv")
  //</editor-fold>
  public /*uint*/int getRegParm() /*const*/ {
    return $3bits_uint2uint(RegParm);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getExtInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 585,
   FQN="clang::CodeGen::CGFunctionInfo::getExtInfo", NM="_ZNK5clang7CodeGen14CGFunctionInfo10getExtInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo10getExtInfoEv")
  //</editor-fold>
  public FunctionType.ExtInfo getExtInfo() /*const*/ {
    return new FunctionType.ExtInfo(isNoReturn(), 
        getHasRegParm(), getRegParm(), 
        getASTCallingConvention(), 
        isReturnsRetained());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getReturnType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 592,
   FQN="clang::CodeGen::CGFunctionInfo::getReturnType", NM="_ZNK5clang7CodeGen14CGFunctionInfo13getReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo13getReturnTypeEv")
  //</editor-fold>
  public CanQual<org.clang.ast.Type> getReturnType() /*const*/ {
    return new CanQual<org.clang.ast.Type>(getArgsBuffer$Const().$star().type);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getReturnInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 594,
   FQN="clang::CodeGen::CGFunctionInfo::getReturnInfo", NM="_ZN5clang7CodeGen14CGFunctionInfo13getReturnInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo13getReturnInfoEv")
  //</editor-fold>
  public ABIArgInfo /*&*/ getReturnInfo() {
    return getArgsBuffer().$star().info;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getReturnInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 595,
   FQN="clang::CodeGen::CGFunctionInfo::getReturnInfo", NM="_ZNK5clang7CodeGen14CGFunctionInfo13getReturnInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo13getReturnInfoEv")
  //</editor-fold>
  public /*const*/ ABIArgInfo /*&*/ getReturnInfo$Const() /*const*/ {
    return getArgsBuffer$Const().$star().info;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getExtParameterInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 597,
   FQN="clang::CodeGen::CGFunctionInfo::getExtParameterInfos", NM="_ZNK5clang7CodeGen14CGFunctionInfo20getExtParameterInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo20getExtParameterInfosEv")
  //</editor-fold>
  public ArrayRef<FunctionProtoType.ExtParameterInfo> getExtParameterInfos() /*const*/ {
    if (!HasExtParameterInfos) {
      return /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/;
    }
    return llvm.makeArrayRef(getExtParameterInfosBuffer$Const(), NumArgs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getExtParameterInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 601,
   FQN="clang::CodeGen::CGFunctionInfo::getExtParameterInfo", NM="_ZNK5clang7CodeGen14CGFunctionInfo19getExtParameterInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo19getExtParameterInfoEj")
  //</editor-fold>
  public FunctionProtoType.ExtParameterInfo getExtParameterInfo(/*uint*/int argIndex) /*const*/ {
    assert ($lesseq_uint(argIndex, NumArgs));
    if (!HasExtParameterInfos) {
      return new FunctionProtoType.ExtParameterInfo();
    }
    return new FunctionProtoType.ExtParameterInfo(getExtParameterInfos().$at(argIndex));
  }

  
  /// \brief Return true if this function uses inalloca arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::usesInAlloca">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 608,
   FQN="clang::CodeGen::CGFunctionInfo::usesInAlloca", NM="_ZNK5clang7CodeGen14CGFunctionInfo12usesInAllocaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo12usesInAllocaEv")
  //</editor-fold>
  public boolean usesInAlloca() /*const*/ {
    return (ArgStruct != null);
  }

  
  /// \brief Get the struct type used to represent all the arguments in memory.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getArgStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 611,
   FQN="clang::CodeGen::CGFunctionInfo::getArgStruct", NM="_ZNK5clang7CodeGen14CGFunctionInfo12getArgStructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo12getArgStructEv")
  //</editor-fold>
  public StructType /*P*/ getArgStruct() /*const*/ {
    return ArgStruct;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::getArgStructAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 612,
   FQN="clang::CodeGen::CGFunctionInfo::getArgStructAlignment", NM="_ZNK5clang7CodeGen14CGFunctionInfo21getArgStructAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK5clang7CodeGen14CGFunctionInfo21getArgStructAlignmentEv")
  //</editor-fold>
  public CharUnits getArgStructAlignment() /*const*/ {
    return CharUnits.fromQuantity($uint2long(ArgStructAlign));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::setArgStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 615,
   FQN="clang::CodeGen::CGFunctionInfo::setArgStruct", NM="_ZN5clang7CodeGen14CGFunctionInfo12setArgStructEPN4llvm10StructTypeENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo12setArgStructEPN4llvm10StructTypeENS_9CharUnitsE")
  //</editor-fold>
  public void setArgStruct(StructType /*P*/ Ty, CharUnits Align) {
    ArgStruct = Ty;
    ArgStructAlign = $long2uint(Align.getQuantity());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 620,
   FQN="clang::CodeGen::CGFunctionInfo::Profile", NM="_ZN5clang7CodeGen14CGFunctionInfo7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    ID.AddInteger_int(getASTCallingConvention().getValue());
    ID.AddBoolean(InstanceMethod);
    ID.AddBoolean(ChainCall);
    ID.AddBoolean(NoReturn);
    ID.AddBoolean(ReturnsRetained);
    ID.AddBoolean(HasRegParm);
    ID.AddInteger_uint($3bits_uint2uint(RegParm));
    ID.AddInteger_uint(Required.getOpaqueData());
    ID.AddBoolean(HasExtParameterInfos);
    if (HasExtParameterInfos) {
      for (FunctionProtoType.ExtParameterInfo paramInfo : getExtParameterInfos())  {
        ID.AddInteger_int($uchar2int(paramInfo.getOpaqueValue()));
      }
    }
    getReturnType().Profile(ID);
    for (final /*const*/ CGFunctionInfoArgInfo /*&*/ I : arguments())  {
      I.type.Profile(ID);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGFunctionInfo::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 638,
   FQN="clang::CodeGen::CGFunctionInfo::Profile", NM="_ZN5clang7CodeGen14CGFunctionInfo7ProfileERN4llvm16FoldingSetNodeIDEbbRKNS_12FunctionType7ExtInfoENS2_8ArrayRefINS_17FunctionProtoType16ExtParameterInfoEEENS0_12RequiredArgsENS_7CanQualINS_4TypeEEENS9_ISG_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen14CGFunctionInfo7ProfileERN4llvm16FoldingSetNodeIDEbbRKNS_12FunctionType7ExtInfoENS2_8ArrayRefINS_17FunctionProtoType16ExtParameterInfoEEENS0_12RequiredArgsENS_7CanQualINS_4TypeEEENS9_ISG_EE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         boolean InstanceMethod, 
         boolean ChainCall, 
         final /*const*/ FunctionType.ExtInfo /*&*/ info, 
         ArrayRef<FunctionProtoType.ExtParameterInfo> paramInfos, 
         RequiredArgs required, 
         CanQual<org.clang.ast.Type> resultType, 
         ArrayRef<CanQual<org.clang.ast.Type>> argTypes) {
    ID.AddInteger_int(info.getCC().getValue());
    ID.AddBoolean(InstanceMethod);
    ID.AddBoolean(ChainCall);
    ID.AddBoolean(info.getNoReturn());
    ID.AddBoolean(info.getProducesResult());
    ID.AddBoolean(info.getHasRegParm());
    ID.AddInteger_uint(info.getRegParm());
    ID.AddInteger_uint(required.getOpaqueData());
    ID.AddBoolean(!paramInfos.empty());
    if (!paramInfos.empty()) {
      for (FunctionProtoType.ExtParameterInfo paramInfo : paramInfos)  {
        ID.AddInteger_int($uchar2int(paramInfo.getOpaqueValue()));
      }
    }
    resultType.Profile(ID);
    for (type$ptr<CanQual<org.clang.ast.Type>> i = $tryClone(argTypes.begin()), /*P*/ e = $tryClone(argTypes.end()); $noteq_ptr(i, e); i.$preInc()) {
      i./*->*/$star().Profile(ID);
    }
  }

  private final type$ptr<?> $This$TrailingObjects = $ITrailingObjectsJavaBase();
    
  @Override
  public final type$ptr<?> $TrailingObjects() {
    assert $This$TrailingObjects != null;
    return $This$TrailingObjects;
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    if (clazz == CGFunctionInfoArgInfo.class) {
      return 0;
    } else {
      assert clazz == FunctionProtoType.ExtParameterInfo.class;
      return numTrailingObjects_OverloadToken$CGFunctionInfoArgInfo(null);
    }
  }
  
  @Override public String toString() {
    return "" + "CallingConvention=" + $uchar2uint(CallingConvention) // NOI18N
              + ", EffectiveCallingConvention=" + $uchar2uint(EffectiveCallingConvention) // NOI18N
              + ", ASTCallingConvention=" + $uchar2uint(ASTCallingConvention) // NOI18N
              + ", InstanceMethod=" + InstanceMethod // NOI18N
              + ", ChainCall=" + ChainCall // NOI18N
              + ", NoReturn=" + NoReturn // NOI18N
              + ", ReturnsRetained=" + ReturnsRetained // NOI18N
              + ", HasRegParm=" + HasRegParm // NOI18N
              + ", RegParm=" + $uchar2uint(RegParm) // NOI18N
              + ", Required=" + Required // NOI18N
              + ", ArgStruct=" + ArgStruct // NOI18N
              + ", ArgStructAlign=" + ArgStructAlign // NOI18N
              + ", HasExtParameterInfos=" + HasExtParameterInfos // NOI18N
              + ", NumArgs=" + NumArgs // NOI18N
              + super.toString(); // NOI18N
  }
}
