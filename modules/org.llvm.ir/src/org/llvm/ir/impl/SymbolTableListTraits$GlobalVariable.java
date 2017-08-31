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

package org.llvm.ir.impl;

import org.clank.support.Converted;
import org.clank.support.Native;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.NativeTrace;
import org.llvm.adt.iplist;
import org.llvm.ir.GlobalVariable;
import org.llvm.ir.Module;
import org.llvm.ir.SymbolTableList;
import org.llvm.ir.SymbolTableListTraits;
import org.llvm.ir.ValueSymbolTable;

//<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalVariable>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 43,
 FQN="llvm::SymbolTableListTraits<GlobalVariable>", NM="_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEEE")
//</editor-fold>
public class SymbolTableListTraits$GlobalVariable implements /*public*/ /*public*/ SymbolTableListTraits<GlobalVariable, Module> {
  // JAVA: typedef SymbolTableList<GlobalVariable> ListTy
//  public final class ListTy extends SymbolTableList<GlobalVariable, Module>{ };
  // JAVA: typedef typename SymbolTableListParentType<GlobalVariable>::type ItemParentClass
//  public final class ItemParentClass extends Module{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalVariable>::SymbolTableListTraits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 80,
   FQN="llvm::SymbolTableListTraits<GlobalVariable>::SymbolTableListTraits", NM="_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEEC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEEC1Ev")
  //</editor-fold>
  public SymbolTableListTraits$GlobalVariable() {
    // : ilist_nextprev_traits<GlobalVariable>(), SymbolTableListSentinelTraits<GlobalVariable>(), ilist_node_traits<GlobalVariable>()
    //START JInit
    super();
    $ilist_default_traits();
    //END JInit
  }

  /*private:*/
  /// getListOwner - Return the object that owns this list.  If this is a list
  /// of instructions, it returns the BasicBlock that owns them.
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalVariable>::getListOwner">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 85,
   FQN="llvm::SymbolTableListTraits<GlobalVariable>::getListOwner", NM="_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE12getListOwnerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE12getListOwnerEv")
  //</editor-fold>
  @Override public Module getListOwner( /*typename*/ /*P*/ iplist<GlobalVariable> list) {
    assert list instanceof SymbolTableList$GlobalVariable : "forgot to pass valid list object?" + NativeTrace.getIdentityStr(list);
    return ((SymbolTableList$GlobalVariable) list).getListOwner(list);
    //      /*size_t*/int Offset/*J*/= ((/*size_t*/int)($AddrOf(((Module /*P*/ )null ->* Module.getSublistAccess(((/*static_cast*/GlobalVariable /*P*/ )((GlobalVariable /*P*/ )null)))))));
    //      SymbolTableList<GlobalVariable, Module>/*P*/ Anchor/*J*/= ((/*static_cast*/SymbolTableList<GlobalVariable, Module>/*P*/ )(this));
    //      return reinterpret_cast(Module /*P*/ .class, reinterpret_cast(char$ptr/*char P*/ .class, Anchor).$sub(Offset));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalVariable>::getList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 93,
   FQN="llvm::SymbolTableListTraits<GlobalVariable>::getList", NM="_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE7getListEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE7getListEPNS_6ModuleE")
  //</editor-fold>
  public SymbolTableList<GlobalVariable, Module> /*&*/ getList( /*P*/ Module Par) {
    //      return Par ->* (Par.getSublistAccess((GlobalVariable /*P*/ )(GlobalVariable /*P*/ )null));
    return /*P*/ Par.getSublistAccess((GlobalVariable) null).$call(Par);
  }

  //private:
  /*template <typename TPtr> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalVariable>::setSymTabObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 109,
   FQN="llvm::SymbolTableListTraits<GlobalVariable>::setSymTabObject", NM="Tpl__ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE15setSymTabObjectEPT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=Tpl__ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE15setSymTabObjectEPT_S3_")
  //</editor-fold>
  public </*typename*/ TPtr> void setSymTabObject(TPtr /*P*/ $Prm0, TPtr $Prm1) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalVariable>::toPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 110,
   FQN="llvm::SymbolTableListTraits<GlobalVariable>::toPtr", NM="_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE5toPtrEPNS_16ValueSymbolTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE5toPtrEPNS_16ValueSymbolTableE")
  //</editor-fold>
  public static ValueSymbolTable /*P*/ toPtr_ValueSymbolTable$P(ValueSymbolTable /*P*/ P) {
    return P;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<GlobalVariable>::toPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/SymbolTableListTraits.h", line = 111,
   FQN="llvm::SymbolTableListTraits<GlobalVariable>::toPtr", NM="_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE5toPtrERNS_16ValueSymbolTableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_14GlobalVariableEE5toPtrERNS_16ValueSymbolTableE")
  //</editor-fold>
  public static ValueSymbolTable /*P*/ toPtr_ValueSymbolTable(final ValueSymbolTable /*&*/ R) {
    return $AddrOf(R);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final GlobalVariable $sentinelField = GlobalVariable.$CreateSentinel();

  @Override
  public GlobalVariable $SentinelField() {
    return $sentinelField;
  }

  @Override
  public Class<GlobalVariable> $getValueSubClass() {
    return GlobalVariable.class;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static class SymbolTableList$GlobalVariable extends SymbolTableList<GlobalVariable, Module> {

    public SymbolTableList$GlobalVariable( /*P*/ Module Owner) {
      super(Owner);
    } /*P*/

    @Override
    public GlobalVariable $SentinelField() {
      return (GlobalVariable) ((SymbolTableListTraits) super.$traits()).$SentinelField();
    }

    @Override
    protected SymbolTableListTraits$GlobalVariable $createTraits() {
      return new SymbolTableListTraits$GlobalVariable();
    }

    @Override
    public Class<GlobalVariable> $getValueSubClass() {
      return ((SymbolTableListTraits) super.$traits()).$getValueSubClass();
    }

  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
