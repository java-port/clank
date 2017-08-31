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

package org.llvm.mc.mcparser;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// \brief Generic Sema callback for assembly parser.
//<editor-fold defaultstate="collapsed" desc="llvm::MCAsmParserSemaCallback">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", line = 49,
 FQN="llvm::MCAsmParserSemaCallback", NM="_ZN4llvm23MCAsmParserSemaCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm23MCAsmParserSemaCallbackE")
//</editor-fold>
public abstract class MCAsmParserSemaCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmParserSemaCallback::~MCAsmParserSemaCallback">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", line = 51,
   FQN="llvm::MCAsmParserSemaCallback::~MCAsmParserSemaCallback", NM="_ZN4llvm23MCAsmParserSemaCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm23MCAsmParserSemaCallbackD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmParserSemaCallback::LookupInlineAsmIdentifier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", line = 52,
   FQN="llvm::MCAsmParserSemaCallback::LookupInlineAsmIdentifier", NM="_ZN4llvm23MCAsmParserSemaCallback25LookupInlineAsmIdentifierERNS_9StringRefERNS_23InlineAsmIdentifierInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm23MCAsmParserSemaCallback25LookupInlineAsmIdentifierERNS_9StringRefERNS_23InlineAsmIdentifierInfoEb")
  //</editor-fold>
  public abstract /*virtual*/ Object/*void P*/ LookupInlineAsmIdentifier(StringRef /*&*/ LineBuf, 
                           InlineAsmIdentifierInfo /*&*/ Info, 
                           boolean IsUnevaluatedContext)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmParserSemaCallback::LookupInlineAsmLabel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", line = 55,
   FQN="llvm::MCAsmParserSemaCallback::LookupInlineAsmLabel", NM="_ZN4llvm23MCAsmParserSemaCallback20LookupInlineAsmLabelENS_9StringRefERNS_9SourceMgrENS_5SMLocEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm23MCAsmParserSemaCallback20LookupInlineAsmLabelENS_9StringRefERNS_9SourceMgrENS_5SMLocEb")
  //</editor-fold>
  public abstract /*virtual*/ StringRef LookupInlineAsmLabel(StringRef Identifier, SourceMgr /*&*/ SM, 
                      SMLoc Location, boolean Create)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmParserSemaCallback::LookupInlineAsmField">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", line = 58,
   FQN="llvm::MCAsmParserSemaCallback::LookupInlineAsmField", NM="_ZN4llvm23MCAsmParserSemaCallback20LookupInlineAsmFieldENS_9StringRefES1_Rj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm23MCAsmParserSemaCallback20LookupInlineAsmFieldENS_9StringRefES1_Rj")
  //</editor-fold>
  public abstract /*virtual*/ boolean LookupInlineAsmField(StringRef Base, StringRef Member, 
                      uint$ref/*uint &*/ Offset)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmParserSemaCallback::MCAsmParserSemaCallback">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCParser/MCAsmParser.h", line = 49,
   FQN="llvm::MCAsmParserSemaCallback::MCAsmParserSemaCallback", NM="_ZN4llvm23MCAsmParserSemaCallbackC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN4llvm23MCAsmParserSemaCallbackC1Ev")
  //</editor-fold>
  public /*inline*/ MCAsmParserSemaCallback() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
