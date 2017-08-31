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

package org.clang.format.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Encapsulates keywords that are context sensitive or for languages not
/// properly supported by Clang's lexer.
//<editor-fold defaultstate="collapsed" desc="clang::format::AdditionalKeywords">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 569,
 FQN="clang::format::AdditionalKeywords", NM="_ZN5clang6format18AdditionalKeywordsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18AdditionalKeywordsE")
//</editor-fold>
public class/*struct*/ AdditionalKeywords {
  //<editor-fold defaultstate="collapsed" desc="clang::format::AdditionalKeywords::AdditionalKeywords">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 570,
   FQN="clang::format::AdditionalKeywords::AdditionalKeywords", NM="_ZN5clang6format18AdditionalKeywordsC1ERNS_15IdentifierTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18AdditionalKeywordsC1ERNS_15IdentifierTableE")
  //</editor-fold>
  public AdditionalKeywords(final IdentifierTable /*&*/ IdentTable) {
    kw_final = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"final"));
    kw_override = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"override"));
    kw_in = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"in"));
    kw_of = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"of"));
    kw_CF_ENUM = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"CF_ENUM"));
    kw_CF_OPTIONS = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"CF_OPTIONS"));
    kw_NS_ENUM = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"NS_ENUM"));
    kw_NS_OPTIONS = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"NS_OPTIONS"));
    
    kw_as = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"as"));
    kw_async = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"async"));
    kw_await = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"await"));
    kw_finally = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"finally"));
    kw_from = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"from"));
    kw_function = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"function"));
    kw_import = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"import"));
    kw_is = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"is"));
    kw_let = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"let"));
    kw_type = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"type"));
    kw_var = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"var"));
    kw_yield = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"yield"));
    
    kw_abstract = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"abstract"));
    kw_assert = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"assert"));
    kw_extends = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"extends"));
    kw_implements = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"implements"));
    kw_instanceof = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"instanceof"));
    kw_interface = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"interface"));
    kw_native = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"native"));
    kw_package = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"package"));
    kw_synchronized = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"synchronized"));
    kw_throws = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"throws"));
    kw___except = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"__except"));
    
    kw_mark = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"mark"));
    
    kw_extend = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"extend"));
    kw_option = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"option"));
    kw_optional = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"optional"));
    kw_repeated = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"repeated"));
    kw_required = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"required"));
    kw_returns = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"returns"));
    
    kw_signals = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"signals"));
    kw_qsignals = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"Q_SIGNALS"));
    kw_slots = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"slots"));
    kw_qslots = /*AddrOf*/IdentTable.get(new StringRef(/*KEEP_STR*/"Q_SLOTS"));
  }

  
  // Context sensitive keywords.
  public IdentifierInfo /*P*/ kw_final;
  public IdentifierInfo /*P*/ kw_override;
  public IdentifierInfo /*P*/ kw_in;
  public IdentifierInfo /*P*/ kw_of;
  public IdentifierInfo /*P*/ kw_CF_ENUM;
  public IdentifierInfo /*P*/ kw_CF_OPTIONS;
  public IdentifierInfo /*P*/ kw_NS_ENUM;
  public IdentifierInfo /*P*/ kw_NS_OPTIONS;
  public IdentifierInfo /*P*/ kw___except;
  
  // JavaScript keywords.
  public IdentifierInfo /*P*/ kw_as;
  public IdentifierInfo /*P*/ kw_async;
  public IdentifierInfo /*P*/ kw_await;
  public IdentifierInfo /*P*/ kw_finally;
  public IdentifierInfo /*P*/ kw_from;
  public IdentifierInfo /*P*/ kw_function;
  public IdentifierInfo /*P*/ kw_import;
  public IdentifierInfo /*P*/ kw_is;
  public IdentifierInfo /*P*/ kw_let;
  public IdentifierInfo /*P*/ kw_type;
  public IdentifierInfo /*P*/ kw_var;
  public IdentifierInfo /*P*/ kw_yield;
  
  // Java keywords.
  public IdentifierInfo /*P*/ kw_abstract;
  public IdentifierInfo /*P*/ kw_assert;
  public IdentifierInfo /*P*/ kw_extends;
  public IdentifierInfo /*P*/ kw_implements;
  public IdentifierInfo /*P*/ kw_instanceof;
  public IdentifierInfo /*P*/ kw_interface;
  public IdentifierInfo /*P*/ kw_native;
  public IdentifierInfo /*P*/ kw_package;
  public IdentifierInfo /*P*/ kw_synchronized;
  public IdentifierInfo /*P*/ kw_throws;
  
  // Pragma keywords.
  public IdentifierInfo /*P*/ kw_mark;
  
  // Proto keywords.
  public IdentifierInfo /*P*/ kw_extend;
  public IdentifierInfo /*P*/ kw_option;
  public IdentifierInfo /*P*/ kw_optional;
  public IdentifierInfo /*P*/ kw_repeated;
  public IdentifierInfo /*P*/ kw_required;
  public IdentifierInfo /*P*/ kw_returns;
  
  // QT keywords.
  public IdentifierInfo /*P*/ kw_signals;
  public IdentifierInfo /*P*/ kw_qsignals;
  public IdentifierInfo /*P*/ kw_slots;
  public IdentifierInfo /*P*/ kw_qslots;
  
  @Override public String toString() {
    return "" + "kw_final=" + kw_final // NOI18N
              + ", kw_override=" + kw_override // NOI18N
              + ", kw_in=" + kw_in // NOI18N
              + ", kw_of=" + kw_of // NOI18N
              + ", kw_CF_ENUM=" + kw_CF_ENUM // NOI18N
              + ", kw_CF_OPTIONS=" + kw_CF_OPTIONS // NOI18N
              + ", kw_NS_ENUM=" + kw_NS_ENUM // NOI18N
              + ", kw_NS_OPTIONS=" + kw_NS_OPTIONS // NOI18N
              + ", kw___except=" + kw___except // NOI18N
              + ", kw_as=" + kw_as // NOI18N
              + ", kw_async=" + kw_async // NOI18N
              + ", kw_await=" + kw_await // NOI18N
              + ", kw_finally=" + kw_finally // NOI18N
              + ", kw_from=" + kw_from // NOI18N
              + ", kw_function=" + kw_function // NOI18N
              + ", kw_import=" + kw_import // NOI18N
              + ", kw_is=" + kw_is // NOI18N
              + ", kw_let=" + kw_let // NOI18N
              + ", kw_type=" + kw_type // NOI18N
              + ", kw_var=" + kw_var // NOI18N
              + ", kw_yield=" + kw_yield // NOI18N
              + ", kw_abstract=" + kw_abstract // NOI18N
              + ", kw_assert=" + kw_assert // NOI18N
              + ", kw_extends=" + kw_extends // NOI18N
              + ", kw_implements=" + kw_implements // NOI18N
              + ", kw_instanceof=" + kw_instanceof // NOI18N
              + ", kw_interface=" + kw_interface // NOI18N
              + ", kw_native=" + kw_native // NOI18N
              + ", kw_package=" + kw_package // NOI18N
              + ", kw_synchronized=" + kw_synchronized // NOI18N
              + ", kw_throws=" + kw_throws // NOI18N
              + ", kw_mark=" + kw_mark // NOI18N
              + ", kw_extend=" + kw_extend // NOI18N
              + ", kw_option=" + kw_option // NOI18N
              + ", kw_optional=" + kw_optional // NOI18N
              + ", kw_repeated=" + kw_repeated // NOI18N
              + ", kw_required=" + kw_required // NOI18N
              + ", kw_returns=" + kw_returns // NOI18N
              + ", kw_signals=" + kw_signals // NOI18N
              + ", kw_qsignals=" + kw_qsignals // NOI18N
              + ", kw_slots=" + kw_slots // NOI18N
              + ", kw_qslots=" + kw_qslots; // NOI18N
  }
}
