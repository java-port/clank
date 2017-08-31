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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.mc.MCContextGlobals.$new_uint_MCContext_uint;


//// \brief  Represent a constant integer expression.
//<editor-fold defaultstate="collapsed" desc="llvm::MCConstantExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 131,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 130,
 FQN="llvm::MCConstantExpr", NM="_ZN4llvm14MCConstantExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm14MCConstantExprE")
//</editor-fold>
public class MCConstantExpr extends /*public*/ MCExpr {
  private long/*int64_t*/ Value;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCConstantExpr::MCConstantExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 133,
   FQN="llvm::MCConstantExpr::MCConstantExpr", NM="_ZN4llvm14MCConstantExprC1Ex",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm14MCConstantExprC1Ex")
  //</editor-fold>
  private /*explicit*/ MCConstantExpr(long/*int64_t*/ Value) {
    // : MCExpr(MCExpr::Constant), Value(Value) 
    //START JInit
    super(MCExpr.ExprKind.Constant);
    this.Value = Value;
    //END JInit
  }

/*public:*/
  /// \name Construction
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCConstantExpr::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 151,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 150,
   FQN="llvm::MCConstantExpr::create", NM="_ZN4llvm14MCConstantExpr6createExRNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm14MCConstantExpr6createExRNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCConstantExpr /*P*/ create(long/*int64_t*/ Value, final MCContext /*&*/ Ctx) {
    return /*NEW_EXPR [operator new] NM=_ZnwjRN4llvm9MCContextEj*/
    /*new (Ctx)*/ $new_uint_MCContext_uint(Ctx, (type$ptr<?> New$Mem)->{
        return new MCConstantExpr(Value);
     });
  }

  
  /// @}
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCConstantExpr::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 146,
   FQN="llvm::MCConstantExpr::getValue", NM="_ZNK4llvm14MCConstantExpr8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm14MCConstantExpr8getValueEv")
  //</editor-fold>
  public long/*int64_t*/ getValue() /*const*/ {
    return Value;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCConstantExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 151,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 150,
   FQN="llvm::MCConstantExpr::classof", NM="_ZN4llvm14MCConstantExpr7classofEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm14MCConstantExpr7classofEPKNS_6MCExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCExpr /*P*/ E) {
    return E.getKind() == MCExpr.ExprKind.Constant;
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
