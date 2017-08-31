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
/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 */

package org.clank.support;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 * @author Vladimir Voskresensky
 */
public final class JavaDifferentiators {
  
  public static final class JD$BaseOf {
    public static final JD$BaseOf INSTANCE = new JD$BaseOf();
    private JD$BaseOf() {}
  }
  
  public static final class JD$BaseOfButNotSame {
    public static final JD$BaseOfButNotSame INSTANCE = new JD$BaseOfButNotSame();
    private JD$BaseOfButNotSame() {}
  }
  
  public static final class JD$NotSame2Callable {
    public static final JD$NotSame2Callable INSTANCE = new JD$NotSame2Callable();
    private JD$NotSame2Callable() {}
  }
  
  public static final class JD$NotBaseOfRemoveCVRef {
    public static final JD$NotBaseOfRemoveCVRef INSTANCE = new JD$NotBaseOfRemoveCVRef();
    private JD$NotBaseOfRemoveCVRef() {}
  }
  
  public static final class JD$IsErrorCodeOrErrorCondition {
    public static final JD$IsErrorCodeOrErrorCondition INSTANCE = new JD$IsErrorCodeOrErrorCondition();
    private JD$IsErrorCodeOrErrorCondition() {}
  }
  
  public static final class JD$Convertible {
    public static final JD$Convertible INSTANCE = new JD$Convertible();
    private JD$Convertible() {}
  }

  public static final class JD$ConvertibleMove {
    public static final JD$ConvertibleMove INSTANCE = new JD$ConvertibleMove();
    private JD$ConvertibleMove() {}
  }
  
  public static final class JD$NotConvertible {
    public static final JD$NotConvertible INSTANCE = new JD$NotConvertible();
    private JD$NotConvertible() {}
  }
  
  public static final class JD$NullPtr {
    public static final JD$NullPtr INSTANCE = new JD$NullPtr();
    private JD$NullPtr() {}
  }
  
  public static final class JD$Move {
    public static final JD$Move INSTANCE = new JD$Move();
    private JD$Move() {}
  }

  public static final class JD$T {
    public static final JD$T INSTANCE = new JD$T();
    private JD$T() {}
  }

  public static final class JD$T1 {
    public static final JD$T1 INSTANCE = new JD$T1();
    private JD$T1() {}
  }

  public static final class JD$T1$P {
    public static final JD$T1$P INSTANCE = new JD$T1$P();
    private JD$T1$P() {}
  }

  public static final class JD$T2 {
    public static final JD$T2 INSTANCE = new JD$T2();
    private JD$T2() {}
  }

  public static final class JD$T2$P {
    public static final JD$T2$P INSTANCE = new JD$T2$P();
    private JD$T2$P() {}
  }

  public static final class JD$T3 {
    public static final JD$T3 INSTANCE = new JD$T3();
    private JD$T3() {}
  }

  public static final class JD$T6$P {
    public static final JD$T6$P INSTANCE = new JD$T6$P();
    private JD$T6$P() {}
  }

  public static final class JD$T7$P {
    public static final JD$T7$P INSTANCE = new JD$T7$P();
    private JD$T7$P() {}
  }
  
  public static final class JD$T$RR_T1$RR {
    public static final JD$T$RR_T1$RR INSTANCE = new JD$T$RR_T1$RR();
    private JD$T$RR_T1$RR() {}
  }

  public static final class JD$T$RR_T1$C$R {
    public static final JD$T$RR_T1$C$R INSTANCE = new JD$T$RR_T1$C$R();
    private JD$T$RR_T1$C$R() {}
  }

  public static final class JD$T$RR {
    public static final JD$T$RR INSTANCE = new JD$T$RR();
    private JD$T$RR() {}
  }

  public static final class JD$Initializer_list$_Key_T1$C$R_T2$C$R {
    public static final JD$Initializer_list$_Key_T1$C$R_T2$C$R INSTANCE = new JD$Initializer_list$_Key_T1$C$R_T2$C$R();
    private JD$Initializer_list$_Key_T1$C$R_T2$C$R() {}
  }

  public static final class JD$T$C$R {
    public static final JD$T$C$R INSTANCE = new JD$T$C$R();
    private JD$T$C$R() {}
  }

  public static final class JD$Pair$_U1$_U2 {
    public static final JD$Pair$_U1$_U2 INSTANCE = new JD$Pair$_U1$_U2();
    private JD$Pair$_U1$_U2() {}
  }

  public static final class JD$Shared_ptr$_Tp1$C {
    public static final JD$Shared_ptr$_Tp1$C INSTANCE = new JD$Shared_ptr$_Tp1$C();
    private JD$Shared_ptr$_Tp1$C() {}
  }

  public static final class JD$Unique_ptr$_Up$_Ep {
    public static final JD$Unique_ptr$_Up$_Ep INSTANCE = new JD$Unique_ptr$_Up$_Ep();
    private JD$Unique_ptr$_Up$_Ep() {}
  }

  public static final class JD$MoveDerived {
    public static final JD$MoveDerived INSTANCE = new JD$MoveDerived();
    private JD$MoveDerived() {}
  }

  public static final class JD$CopyDerived {
    public static final JD$CopyDerived INSTANCE = new JD$CopyDerived();
    private JD$CopyDerived() {}
  }

  public static final class JD$Char {
    public static final JD$Char INSTANCE = new JD$Char();
    private JD$Char() {}
  }
  
  public static final class JD$SChar {
    public static final JD$SChar INSTANCE = new JD$SChar();
    private JD$SChar() {}
  }
  
  public static final class JD$UChar {
    public static final JD$UChar INSTANCE = new JD$UChar();
    private JD$UChar() {}
  }
  
  public static final class JD$Int {
    public static final JD$Int INSTANCE = new JD$Int();
    private JD$Int() {}
  }
  
  public static final class JD$UInt {
    public static final JD$UInt INSTANCE = new JD$UInt();
    private JD$UInt() {}
  }
  
  public static final class JD$Long {
    public static final JD$Long INSTANCE = new JD$Long();
    private JD$Long() {}
  }
  
  public static final class JD$ULong {
    public static final JD$ULong INSTANCE = new JD$ULong();
    private JD$ULong() {}
  }
  
  public static final class JD$LLong {
    public static final JD$LLong INSTANCE = new JD$LLong();
    private JD$LLong() {}
  }
  
  public static final class JD$ULLong {
    public static final JD$ULLong INSTANCE = new JD$ULLong();
    private JD$ULLong() {}
  }
  
  public static final class JD$UInt_ULong {
    public static final JD$UInt_ULong INSTANCE = new JD$UInt_ULong();
    private JD$UInt_ULong() {}
  }
  
  public static final class JD$UInt_UInt {
    public static final JD$UInt_UInt INSTANCE = new JD$UInt_UInt();
    private JD$UInt_UInt() {}
  }
  
  public static final class JD$UInt_T$C$R {
    public static final JD$UInt_T$C$R INSTANCE = new JD$UInt_T$C$R();
    private JD$UInt_T$C$R() {}
  }
  
  public static final class JD$T$C$R_T$RR {
    public static final JD$T$C$R_T$RR INSTANCE = new JD$T$C$R_T$RR();
    private JD$T$C$R_T$RR() {}
  }
  
  // see clang::DeclarationName::DeclarationName
  // used to have 2 params instead of 1 in new DeclarationName(param) when param
  // is instance of class from impl package, which is invisible from other modules
  // so cause an ambiguity and compiler error
  public static final class JD$Private {
    public static final JD$Private INSTANCE = new JD$Private();
    private JD$Private() {}
  }

  public static final class JD$ConstVoidPtr {
    public static final JD$ConstVoidPtr INSTANCE = new JD$ConstVoidPtr();
    private JD$ConstVoidPtr() {}
  }

  public static final class JD$VolatileVoidPtr {
    public static final JD$VolatileVoidPtr INSTANCE = new JD$VolatileVoidPtr();
    private JD$VolatileVoidPtr() {}
  }

  public static final class JD$Object$C {
    public static final JD$Object$C INSTANCE = new JD$Object$C();
    private JD$Object$C() {}
  }

  public static final class JD$Object$V {
    public static final JD$Object$V INSTANCE = new JD$Object$V();
    private JD$Object$V() {}
  }
  
  public static final class JD$T$C$P_T2$C$R {
    public static final JD$T$C$P_T2$C$R INSTANCE = new JD$T$C$P_T2$C$R();
    private JD$T$C$P_T2$C$R() {}
  }


  public static final class JD$DelayedDiagnosticPool$C$P {
    public static final JD$DelayedDiagnosticPool$C$P INSTANCE = new JD$DelayedDiagnosticPool$C$P();
    private JD$DelayedDiagnosticPool$C$P() {}
  }

  public static final class JD$NamedDecl$P {
    public static final JD$NamedDecl$P INSTANCE = new JD$NamedDecl$P();
    public JD$NamedDecl$P() {}
  }

  public static final class JD$IdDeclInfoPool$P {
    public static final JD$IdDeclInfoPool$P INSTANCE = new JD$IdDeclInfoPool$P();
    private JD$IdDeclInfoPool$P() {}
  }
  // For miscellaneous purposes
  public static final class JD$Misc {
    public static final JD$Misc INSTANCE = new JD$Misc();
    private JD$Misc() {}
  }

  public static final class JD$NoCloneInput {
    public static final JD$NoCloneInput INSTANCE = new JD$NoCloneInput();
    private JD$NoCloneInput() {}
  }

  public static final class JD$Reverse_iterator$_Iter$C {
    public static final JD$Reverse_iterator$_Iter$C INSTANCE = new JD$Reverse_iterator$_Iter$C();
    private JD$Reverse_iterator$_Iter$C() {}
  }
  
  public static final class JD$Long$C {
    public static final JD$Long$C INSTANCE = new JD$Long$C();
    private JD$Long$C() {}
  }
  
  public static final class JD$ConstULLongRef {
    public static final JD$ConstULLongRef INSTANCE = new JD$ConstULLongRef();
    private JD$ConstULLongRef() {}
  }

  /** 
   * The special Trailing differentiator when it is required to help Javac's name resolution.
   * Java checks all functions/ctrs first by num of params and if one of parameters
   * has name invisible for the client it will produce the error which is not very
   * clear. 
   * 
   * Add required number of 'JD$FAKE _dparmN' at the end and exclude function 
   * from Javac's name resolution set.
   * IMPORTANT: add also mapping by NM of function to JConvert/options/constructor_parameters.properties
   * See: clang/basic clang::Selector::Selector(MultiKeywordSelector) as an example
   */
  public static final class JD$FAKE {
    public static final JD$FAKE TRAILING = new JD$FAKE();
    private JD$FAKE() {}
  }
  
  /**
   * The special Trailing differentiator when it is required to help ExprWithCleanup
   * to clean input argument of the parent constructor.
   */
  public static final class JD$Clean {
    public static final JD$Clean TRAILING = new JD$Clean();
    private JD$Clean() {}
  }
  
  private JavaDifferentiators() {
    throw new AssertionError();
  }
}
